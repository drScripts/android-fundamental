package com.example.mytestingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import java.lang.StringBuilder
import kotlin.math.log

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnSetValue : Button
    private lateinit var textValue   : TextView
    private lateinit var imgValue   : ImageView
    private var listName = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textValue = findViewById(R.id.tv_text)
        btnSetValue = findViewById(R.id.btn_set_value)
        btnSetValue.setOnClickListener(this)
        imgValue = findViewById(R.id.image_view)

        // image terlalu besar dapat diperkecil dengan menggunakan Glide
        // imgValue.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.Fronalpstock_big))

        Glide.with(this)
            .load(R.drawable.Fronalpstock_big)
            .into(imgValue)

        listName.add("Narenda Wicaksono")
        listName.add("Kevin")
        listName.add("Yoza")

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_set_value -> {
               // textValue.text = "19"
                Log.d("MainActivity",listName.toString())
                val name = StringBuilder()
                for (i in listName){
                    name.append(i).append("\n")
                }
                textValue.text = name.toString()
            }
        }
    }
}