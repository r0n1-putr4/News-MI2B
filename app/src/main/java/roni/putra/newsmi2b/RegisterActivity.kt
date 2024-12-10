package roni.putra.newsmi2b

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import roni.putra.newsmi2b.api.ApiClient
import roni.putra.newsmi2b.api.ApiService
import roni.putra.newsmi2b.model.RegisterResponse

class RegisterActivity : AppCompatActivity() {
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var etFullname: EditText
    private lateinit var etEmail: EditText
    private lateinit var btnRegister: Button
    private lateinit var progressBar: ProgressBar
    private lateinit var tvLogin: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        etFullname = findViewById(R.id.etFullname)
        etEmail = findViewById(R.id.etEmail)
        btnRegister = findViewById(R.id.btnRegister)
        progressBar = findViewById(R.id.progressBar)
        tvLogin = findViewById(R.id.tvLogin)

        btnRegister.setOnClickListener {
            prosesRegister()
        }
        tvLogin.setOnClickListener {
            startActivity(Intent(this@RegisterActivity,LoginActivity::class.java))
        }

    }

    private fun prosesRegister() {
        progressBar.visibility = View.VISIBLE
        ApiClient.apiService.register(
            etUsername.text.toString(),
            etPassword.text.toString(),
            etFullname.text.toString(),
            etEmail.text.toString()
        ).enqueue(object : Callback<RegisterResponse> {
            override fun onResponse(
                call: Call<RegisterResponse>, response: Response<RegisterResponse>
            ) {
                progressBar.visibility = View.VISIBLE
                if (response.isSuccessful) {
                    Toast.makeText(
                        this@RegisterActivity, response.body()?.message, Toast.LENGTH_SHORT
                    ).show()
                    startActivity(Intent(this@RegisterActivity,MainActivity::class.java))
                    progressBar.visibility = View.GONE
                } else {
                    val errorMessage = response.errorBody()?.string() ?: "Unknown error"
                    Toast.makeText(
                        this@RegisterActivity, "Register failed $errorMessage", Toast.LENGTH_SHORT
                    ).show()
                    progressBar.visibility = View.GONE
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Toast.makeText(this@RegisterActivity, t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
}