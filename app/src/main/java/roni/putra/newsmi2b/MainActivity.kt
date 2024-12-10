package roni.putra.newsmi2b

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var btnSignUp: Button
<<<<<<< HEAD
    private lateinit var btnLogin: Button
=======
>>>>>>> origin/main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btnSignUp = findViewById(R.id.btnSignUp)
<<<<<<< HEAD
        btnLogin = findViewById(R.id.btnLogin)
=======
>>>>>>> origin/main

        btnSignUp.setOnClickListener {
            startActivity(Intent(this@MainActivity, RegisterActivity::class.java))
        }

<<<<<<< HEAD
        btnLogin.setOnClickListener {
            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
        }
=======
>>>>>>> origin/main
    }


}