package com.example.parcelable

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var btnParcel : Button
    lateinit var btnParcelize : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnParcel = findViewById(R.id.btn_parcel)
        btnParcel.setOnClickListener(this)

        btnParcelize = findViewById(R.id.btn_parcel_parcelize)
        btnParcelize.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_parcel -> {
                val person = Person(
                    name = "Nathanael Valentino Davis",
                    age = 18,
                    city = "Bandung",
                    email = "nathanael.vd@gmail.com"
                )

                val intentParcelable = Intent(this@MainActivity,DataObjectActivity::class.java)
                intentParcelable.putExtra(DataObjectActivity.EXTRA_PERSON,person)
                startActivity(intentParcelable)
            }

            R.id.btn_parcel_parcelize -> {
                val person = PersonParcel(
                    name = "Nathanael Valentino Davis",
                    age = 18,
                    city = "Bandung",
                    email = "nathanael.vd@gmail.com"
                )

                val intent = Intent(this@MainActivity,DataObjectActivity::class.java)
                intent.putExtra(DataObjectActivity.EXTRA_PERSON,person)
                startActivity(intent)
            }
        }
    }
}



