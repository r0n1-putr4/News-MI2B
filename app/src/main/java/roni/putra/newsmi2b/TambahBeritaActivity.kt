package roni.putra.newsmi2b

import android.app.Activity
import android.app.ComponentCaller
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.github.dhaval2404.imagepicker.ImagePicker
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import roni.putra.newsmi2b.api.ApiClient
import roni.putra.newsmi2b.api.ApiService
import roni.putra.newsmi2b.model.AddBeritaResponse
import roni.putra.newsmi2b.model.BeritaResponse
import java.io.File

class TambahBeritaActivity : AppCompatActivity() {
    private lateinit var etJudul: EditText
    private lateinit var btnFileGambar: Button
    private lateinit var tvSelectedFile: TextView
    private lateinit var etIsi: TextView
    private lateinit var btnTambah: Button
    private lateinit var progressBar: ProgressBar

    private var imageFile: File? = null
    private val storagePermissionCode = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tambah_berita)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        etJudul = findViewById(R.id.etJudul)
        btnFileGambar = findViewById(R.id.btnFileGambar)
        tvSelectedFile = findViewById(R.id.tvSelectedFile)
        etIsi = findViewById(R.id.etIsi)
        btnTambah = findViewById(R.id.btnTambah)
        progressBar = findViewById(R.id.progressBar)

        checkStoragePermission()
        btnFileGambar.setOnClickListener {
            //selectFile()
            ImagePicker.with(this)
                .crop()
                .compress(1024)
                .maxResultSize(1080, 1080)
                .start()
        }
        btnTambah.setOnClickListener {
            imageFile?.let { file ->
                addBerita(etJudul.text.toString(), etIsi.text.toString(), file)
            }
        }

    }

    private fun addBerita(judul: String, isi: String, fileGambar: File) {
        progressBar.visibility = View.VISIBLE

        val requestBody = fileGambar.asRequestBody("multipart/form-data".toMediaTypeOrNull())
        val part = MultipartBody.Part.createFormData("fileGambar", fileGambar.name, requestBody)

        val title = judul.toRequestBody("text/plain".toMediaTypeOrNull())
        val description = isi.toRequestBody("text/plain".toMediaTypeOrNull())

        ApiClient.apiService.addBerita(title, description, part)
            .enqueue(object : Callback<AddBeritaResponse> {
                override fun onResponse(
                    call: Call<AddBeritaResponse>,
                    response: Response<AddBeritaResponse>
                ) {
                    if (response.isSuccessful) {
                        if (response.body()!!.success) {
                            startActivity(
                                Intent(
                                    this@TambahBeritaActivity,
                                    DashboardActivity::class.java
                                )
                            )
                        } else {
                            Toast.makeText(
                                this@TambahBeritaActivity,
                                "Register failed ${response.body()!!.message}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        progressBar.visibility = View.GONE
                    } else {
                        val errorMessage = response.errorBody()?.string() ?: "Unknown error"
                        Toast.makeText(
                            this@TambahBeritaActivity,
                            " failed $errorMessage",
                            Toast.LENGTH_SHORT
                        ).show()
                        progressBar.visibility = View.GONE
                    }
                }

                override fun onFailure(call: Call<AddBeritaResponse>, t: Throwable) {
                    Toast.makeText(
                        this@TambahBeritaActivity,
                        " failed ${t.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                    progressBar.visibility = View.GONE
                }
            })

    }

    private fun checkStoragePermission() {
        if (ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.READ_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),
                storagePermissionCode
            )
        } else {
            ActivityCompat.requestPermissions(
                this, arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), 1
            )
        }
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK && data != null) {
            val uri = data.data!!
            imageFile = File(uri.path!!)
            tvSelectedFile.text = imageFile!!.name
        }
    }
}