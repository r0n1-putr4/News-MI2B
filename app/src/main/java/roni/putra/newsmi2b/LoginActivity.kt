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
import roni.putra.newsmi2b.model.LoginResponse

class LoginActivity : AppCompatActivity() {

    private lateinit var tvSignUp: TextView
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tvSignUp = findViewById(R.id.tvSignUp)
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        progressBar = findViewById(R.id.progressBar)

        tvSignUp.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
        }

        btnLogin.setOnClickListener {
            prosesLogin()
        }

    }

    private fun prosesLogin() {
        progressBar.visibility = View.VISIBLE
        ApiClient.apiService.login(etUsername.text.toString(), etPassword.text.toString())
            .enqueue(object : Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    if (response.isSuccessful) {
                        if (response.body()!!.success){
                            startActivity(Intent(this@LoginActivity,DashboardActivity::class.java))
                        }else{
                            Toast.makeText(
                                this@LoginActivity, "Login failed ${response.body()!!.message}", Toast.LENGTH_SHORT
                            ).show()
                        }
                        progressBar.visibility = View.GONE
                    } else {
                        val errorMessage = response.errorBody()?.string() ?: "Unknown error"
                        Toast.makeText(
                            this@LoginActivity, "Login failed $errorMessage", Toast.LENGTH_SHORT
                        ).show()
                        progressBar.visibility = View.GONE
                    }

                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Toast.makeText(this@LoginActivity,"Gagal Login", Toast.LENGTH_SHORT).show()
                    progressBar.visibility = View.GONE
                }
            })
    }
}