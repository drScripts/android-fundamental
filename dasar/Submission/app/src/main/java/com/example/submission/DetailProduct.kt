package com.example.submission

import android.content.Intent
import android.content.res.Resources
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import org.w3c.dom.Text

class DetailProduct : AppCompatActivity(), View.OnClickListener {

    companion object{
        const val EXTRA_PRODUCT_IMAGE = "extra_image"
        const val EXTRA_PRODUCT_NAME = "extra_name"
        const val EXTRA_PRODUCT_DETAIL = "extra_detail"
        const val EXTRA_PRODUCT_LINK = "extra_link"
        const val EXTRA_PRODUCT_PRICE = "extra_price"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_product)

        // data intent
        val name = intent.getStringExtra(EXTRA_PRODUCT_NAME)
        val detail = intent.getStringExtra(EXTRA_PRODUCT_DETAIL)
        val price = intent.getStringExtra(EXTRA_PRODUCT_PRICE)
        val image = intent.getIntExtra(EXTRA_PRODUCT_IMAGE,0)

        // set title
        supportActionBar!!.title = name
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)


        val Image : ImageView = findViewById(R.id.product_image)
        val productName : TextView = findViewById(R.id.product_name)
        val productPrice : TextView = findViewById(R.id.product_price)
        val productDetailProduct : TextView = findViewById(R.id.product_detail)
        val likeImage : ImageView = findViewById(R.id.btn_like)
        val shareImage : ImageView = findViewById(R.id.btn_share)
        val btnBuy : Button = findViewById(R.id.btn_buy_product)



        Glide.with(this)
            .load(image)
            .apply(RequestOptions().override(0,300))
            .override(Resources.getSystem().displayMetrics.widthPixels)
            .into(Image)
        productName.text = name
        productPrice.text = price
        productDetailProduct.text = detail

        likeImage.setOnClickListener(this)
        shareImage.setOnClickListener(this)
        btnBuy.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_like -> {
                Glide.with(this)
                    .load(R.drawable.liked)
                    .into(findViewById(R.id.btn_like))
                Toast.makeText(this," The Item Has Added To Wishlist ",Toast.LENGTH_SHORT).show()
            }
            R.id.btn_share -> {
                val sendIntent : Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT,intent.getStringExtra(EXTRA_PRODUCT_LINK))
                    type = "text/plain"
                }
                val shareActivity = Intent.createChooser(sendIntent,null)
                startActivity(shareActivity).also {
                    Toast.makeText(this,"Shared Link Has Been Copied",Toast.LENGTH_SHORT).show()
                }
            }
            R.id.btn_buy_product -> {
                Toast.makeText(this,"You Purchase " + intent.getStringExtra(EXTRA_PRODUCT_NAME),Toast.LENGTH_LONG).show()
            }
        }
    }
}






