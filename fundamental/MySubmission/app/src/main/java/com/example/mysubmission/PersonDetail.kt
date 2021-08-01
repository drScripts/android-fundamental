package com.example.mysubmission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class PersonDetail : AppCompatActivity() {

    companion object{
        const val EXTRA_PERSON = "extra_person"
    }

    private lateinit var imgPerson : ImageView
    private lateinit var namePerson : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_detail)

        val person = intent.getParcelableExtra<PersonModel>(EXTRA_PERSON)
        imgPerson = findViewById(R.id.person_img)
        namePerson = findViewById(R.id.person_name)

        Glide.with(this)
            .load(person?.image?:R.drawable.ic_baseline_business_24)
            .into(imgPerson)
        namePerson.text = person?.name?:"Nathan"
    }
}














