package com.example.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListHeroAdapter(private val listHero: ArrayList<Hero>):RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {
    class ListViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var tvName : TextView = itemView.findViewById(R.id.tv_item_name)
        var tvdetail : TextView = itemView.findViewById(R.id.tv_item_details)
        var image : ImageView = itemView.findViewById(R.id.img_item_photo)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_hero, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val hero = listHero[position]
        Glide.with(holder.itemView.context)
            .load(hero.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.image)
        holder.tvName.text = hero.name
        holder.tvdetail.text = hero.detail
    }

    override fun getItemCount(): Int {
        return listHero.size
    }
}