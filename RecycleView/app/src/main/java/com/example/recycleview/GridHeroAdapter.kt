package com.example.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class GridHeroAdapter(val list : ArrayList<Hero>) : RecyclerView.Adapter<GridHeroAdapter.GridViewHolder>() {
    class GridViewHolder(item : View) : RecyclerView.ViewHolder(item) {
        // getting img Foto from item
        var imgFoto: ImageView = item.findViewById(R.id.img_item_photo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        // implement inflater
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.layoit_grid,parent,false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        // push Data with Glide
        Glide.with(holder.itemView.context)
            .load(list[position].photo)
            .apply(RequestOptions().override(350,550))
            .into(holder.imgFoto)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}






