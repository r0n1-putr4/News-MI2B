package roni.putra.newsmi2b

import android.content.Intent
import android.os.Bundle
import android.service.controls.actions.FloatAction
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.SearchView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import roni.putra.newsmi2b.adapter.BeritaAdapter
import roni.putra.newsmi2b.api.ApiClient
import roni.putra.newsmi2b.api.ApiService
import roni.putra.newsmi2b.model.BeritaResponse

class DashboardActivity : AppCompatActivity() {
    private lateinit var beritaAdapter: BeritaAdapter
    private lateinit var rvNews: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var svJudul: SearchView
    private lateinit var fab_tambah: FloatingActionButton
    private lateinit var imgNotFound: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        rvNews = findViewById(R.id.rvWisata)
        progressBar = findViewById(R.id.progressBar)
        svJudul = findViewById(R.id.svWisata)
        fab_tambah = findViewById(R.id.floatBtnTambah)
        imgNotFound = findViewById(R.id.imgNotFound)

        getBerita("")

        svJudul.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                getBerita(newText.toString())
                return true
            }
        })

        fab_tambah.setOnClickListener {
            startActivity(Intent(this@DashboardActivity,TambahBeritaActivity::class.java))
        }

    }

    private fun getBerita(judul: String) {
        progressBar.visibility = View.VISIBLE
        ApiClient.apiService.getBerita(judul).enqueue(object : Callback<BeritaResponse> {
            override fun onResponse(
                call: Call<BeritaResponse>,
                response: Response<BeritaResponse>
            ) {

                if (response.isSuccessful) {
                    if (response.body()!!.success) {
                        //setData
                        beritaAdapter= BeritaAdapter(arrayListOf())
                        rvNews.adapter = beritaAdapter
                        beritaAdapter.setData(response.body()!!.data)
                        imgNotFound.visibility = View.GONE

                    }else{
                        beritaAdapter= BeritaAdapter(arrayListOf())
                        rvNews.adapter = beritaAdapter
                        imgNotFound.visibility = View.VISIBLE
                    }
                    progressBar.visibility = View.GONE
                }
            }

            override fun onFailure(call: Call<BeritaResponse>, t: Throwable) {
                Toast.makeText(
                    this@DashboardActivity, "Tidak Terhubung Ke Server",
                    Toast.LENGTH_LONG
                ).show()
                progressBar.visibility = View.GONE
            }
        })
    }
}