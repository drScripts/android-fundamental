package com.example.parcelable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DataObjectActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_object)

        val tvObjectData : TextView = findViewById(R.id.tv_object_data)

        val personData = intent.getParcelableExtra<PersonParcel>(EXTRA_PERSON)
        val text = "Name : ${personData?.name.toString()} \nAge : ${personData?.age.toString()} \nEmail : ${personData?.age.toString()} \nCity : ${personData?.city.toString()}"
        tvObjectData.text = text
    }
}