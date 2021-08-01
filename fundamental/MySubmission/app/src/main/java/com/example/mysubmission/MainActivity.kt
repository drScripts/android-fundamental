package com.example.mysubmission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvPerson : RecyclerView
    private var listPersons : ArrayList<PersonModel> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvPerson = findViewById(R.id.rv_persons)
        rvPerson.setHasFixedSize(true)

        listPersons.addAll(Persons.datalist)
        showData()
    }

    private fun showData() {
        rvPerson.layoutManager = LinearLayoutManager(this)
        rvPerson.adapter = PersonLinearAdapter(this,listPersons)
    }

}