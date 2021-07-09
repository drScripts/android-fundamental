package com.example.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CardHeroAdapter(var list : ArrayList<Hero>) : RecyclerView.Adapter<CardHeroAdapter.CardViewHolder>() {
    class CardViewHolder(item : View) : RecyclerView.ViewHolder(item) {
        var photo : ImageView = item.findViewById(R.id.img_item_photo)
        var tvDetail : TextView = item.findViewById(R.id.tv_item_details)
        var tvName : TextView = item.findViewById(R.id.tv_item_name)
        var btnFav : Button = item.findViewById(R.id.btn_set_favorite)
        var btnShare : Button = item.findViewById(R.id.btn_set_share)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        // layout IN flater
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.layout_card,parent,false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        Glide.with(holder.photo) // memilih layout image yang akan dii ubah
            .load(list[position].photo) // ambil darii list
            .apply(RequestOptions().override(120,210)) // set ukuran
            .into(holder.photo) // memasukan ke view layout

        // mengubah name dari holder
        holder.tvName.text = list[position].name

        // mengubah detail dari holder
        holder.tvDetail.text = list[position].detail

        // btn clicker set
        holder.btnFav.setOnClickListener{Toast.makeText(holder.itemView.context, " Favorite " + list[holder.adapterPosition].name, Toast.LENGTH_SHORT).show() }
        holder.btnShare.setOnClickListener{ Toast.makeText(holder.itemView.context, "Share " + list[holder.adapterPosition].name, Toast.LENGTH_SHORT).show() }
        holder.itemView.setOnClickListener { Toast.makeText(holder.itemView.context, "Kamu Memilih " + list[holder.adapterPosition].name, Toast.LENGTH_SHORT).show() }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}



