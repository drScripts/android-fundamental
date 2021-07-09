package com.example.submission

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class GridItemAdapter( var listProduct : ArrayList<Product>) : RecyclerView.Adapter<GridItemAdapter.GridItemHolder>(){

    class GridItemHolder(item : View) : RecyclerView.ViewHolder(item) {
        // mengambil view yang akan di load
        var productImage : ImageView = item.findViewById(R.id.product_image)
        var productName : TextView = item.findViewById(R.id.product_name)
        var productPrice : TextView = item.findViewById(R.id.product_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridItemHolder {
        // inflater view
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_card_layout,parent,false)
        return  GridItemHolder(view)
    }

    override fun onBindViewHolder(holder: GridItemHolder, position: Int) {
        // setting view data
        Glide.with(holder.itemView.context)
            .load(listProduct[position].fotoProduct)
            .apply(RequestOptions().override(180,200))
            .into(holder.productImage)

        holder.productName.text = listProduct[position].nameProduct
        val price = "Rp${listProduct[position].priceProduct}"
        holder.productPrice.text = price

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,DetailProduct::class.java)
            intent.putExtra(DetailProduct.EXTRA_PRODUCT_NAME,listProduct[position].nameProduct)
            intent.putExtra(DetailProduct.EXTRA_PRODUCT_DETAIL,listProduct[position].detailProduct)
            intent.putExtra(DetailProduct.EXTRA_PRODUCT_LINK,listProduct[position].sharedLink)
            intent.putExtra(DetailProduct.EXTRA_PRODUCT_PRICE,price)
            intent.putExtra(DetailProduct.EXTRA_PRODUCT_IMAGE,listProduct[position].fotoProduct)
            ContextCompat.startActivity(holder.itemView.context,intent, Bundle.EMPTY)
        }
    }

    override fun getItemCount(): Int {
        return listProduct.size
    }

}





