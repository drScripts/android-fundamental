package com.example.mylistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView



class MainActivity : AppCompatActivity() {

    private val dataName = arrayOf("Cut Nyak Dien", "Ki Hajar Dewantara", "Moh Yamin", "Pattimura", "R A Kartini", "Sukarno")
    private lateinit var adapter: HeroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listView : ListView = findViewById(R.id.lv_hero)

        // basic adapter
        // val lvAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,android.R.id.text1,dataName)
        adapter = HeroAdapter(this,Heroes.dataList)
        listView.adapter = adapter
    }
}