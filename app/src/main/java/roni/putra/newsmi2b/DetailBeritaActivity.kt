package roni.putra.newsmi2b

import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.squareup.picasso.Picasso


class DetailBeritaActivity : AppCompatActivity() {
    private lateinit var imgBerita: ImageView
    private lateinit var tvJudul: TextView
    private lateinit var tvTanggal: TextView
    private lateinit var tvRating: TextView
    private lateinit var tvIsi: TextView
    private lateinit var ratingBar: RatingBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_berita)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        imgBerita = findViewById(R.id.imgBerita)
        tvJudul = findViewById(R.id.tvJudul)
        tvTanggal = findViewById(R.id.tvTanggal)
        tvRating = findViewById(R.id.tvRating)
        ratingBar = findViewById(R.id.ratingBar)
        tvIsi = findViewById(R.id.tvIsi)

        val gambar = intent.getStringExtra("gambar")
        val judul = intent.getStringExtra("judul")
        val tgl_indonesia_berita = intent.getStringExtra("tgl_indonesia_berita")
        val rating = intent.getDoubleExtra("rating", 0.0)
        val isi = intent.getStringExtra("isi")

        Picasso.get().load(gambar).into(imgBerita)
        tvJudul.text = judul
        tvTanggal.text = tgl_indonesia_berita
        ratingBar.rating = rating.toFloat()
        tvRating.text = "${rating}"
        tvIsi.text = isi


    }
}