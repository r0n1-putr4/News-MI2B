package roni.putra.newsmi2b.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import roni.putra.newsmi2b.R
import roni.putra.newsmi2b.model.BeritaResponse

class BeritaAdapter(
    val hasil: ArrayList<BeritaResponse.ListItems>
) : RecyclerView.Adapter<BeritaAdapter.ViewHolder>() {

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val imgBerita = view.findViewById<ImageView>(R.id.imgBerita)
        val tvJudul = view.findViewById<TextView>(R.id.tvJudul)
        val tvTanggal = view.findViewById<TextView>(R.id.tvTanggal)
        val tvRating = view.findViewById<TextView>(R.id.tvRating)
        val ratingBar = view.findViewById<RatingBar>(R.id.ratingBar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_items_new, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hasil.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hasilResponse = hasil[position]
        Picasso.get().load(hasilResponse.gambar).into(holder.imgBerita)
        holder.tvJudul.text = hasilResponse.judul
        holder.tvTanggal.text = hasilResponse.tgl_indonesia_berita
        holder.ratingBar.rating = hasilResponse.rating.toFloat()
        holder.tvRating.text = "${hasilResponse.rating}"
    }

    fun setData(data: List<BeritaResponse.ListItems>){
        hasil.clear()
        hasil.addAll(data)
    }


}