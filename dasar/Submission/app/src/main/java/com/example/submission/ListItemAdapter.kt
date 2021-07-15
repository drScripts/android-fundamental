package com.example.submission

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

class ListItemAdapter(val listproduct : ArrayList<Product>):RecyclerView.Adapter<ListItemAdapter.ListItemHolder>() {
    class ListItemHolder(item : View) : RecyclerView.ViewHolder(item) {
        var productImage : ImageView = item.findViewById(R.id.product_image)
        var productName : TextView = item.findViewById(R.id.product_name)
        var productPrice : TextView = item.findViewById(R.id.product_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.list_item_card,parent,false)
        return ListItemHolder(view)
    }

    override fun onBindViewHolder(holder: ListItemHolder, position: Int) {
        // setting view data
        Glide.with(holder.itemView.context)
            .load(listproduct[position].fotoProduct)
            .apply(RequestOptions().override(180,200))
            .into(holder.productImage)

        holder.productName.text = listproduct[position].nameProduct
        val price = "Rp${listproduct[position].priceProduct}"
        holder.productPrice.text = price

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,DetailProduct::class.java)
            intent.putExtra(DetailProduct.EXTRA_PRODUCT_NAME,listproduct[position].nameProduct)
            intent.putExtra(DetailProduct.EXTRA_PRODUCT_DETAIL,listproduct[position].detailProduct)
            intent.putExtra(DetailProduct.EXTRA_PRODUCT_LINK,listproduct[position].sharedLink)
            intent.putExtra(DetailProduct.EXTRA_PRODUCT_PRICE,price)
            intent.putExtra(DetailProduct.EXTRA_PRODUCT_IMAGE,listproduct[position].fotoProduct)
            ContextCompat.startActivity(holder.itemView.context,intent, Bundle.EMPTY)
        }
    }

    override fun getItemCount(): Int {
        return listproduct.size
    }
}