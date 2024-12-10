package roni.putra.newsmi2b

<<<<<<< HEAD
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
=======
import android.os.Bundle
>>>>>>> origin/main
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
<<<<<<< HEAD

    private lateinit var tvSignUp : TextView
=======
>>>>>>> origin/main
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
<<<<<<< HEAD
        tvSignUp = findViewById(R.id.tvSignUp)

        tvSignUp.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
        }
=======
>>>>>>> origin/main

    }
}