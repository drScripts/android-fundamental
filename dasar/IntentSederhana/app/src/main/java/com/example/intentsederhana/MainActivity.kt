package com.example.intentsederhana

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity:Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveActivityWithData : Button = findViewById(R.id.btn_move_withData)
        btnMoveActivityWithData.setOnClickListener(this)

        // implicit intent
        val btnMoveActivityDialNumber : Button = findViewById(R.id.btn_dial_number)
        btnMoveActivityDialNumber.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_move_activity -> {
                // menambahkan intent untuk pidah ke move activity
                val moveIntent = Intent(this@MainActivity,MoveActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_move_withData -> {
                // menambahkan intent untuk pidah dengan data
                val moveIntentData = Intent(this@MainActivity,MoveWithDataActivity::class.java)
                // set intent value dari object companion di MoveWithDataActivity.kt
                moveIntentData.putExtra(MoveWithDataActivity.EXTRA_NAME,"Nathanael")
                moveIntentData.putExtra(MoveWithDataActivity.EXTRA_AGE,18)

                // menjalankan activity
                startActivity(moveIntentData)
            }
            // implicit intent
            R.id.btn_dial_number -> {
                // intent implicit dimana ia langsung melakukan intent terhadap aplikasi lain

                val phoneNumber = "085777716380"
                val dialPhoneNumber = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneNumber)
            }
        }
    }


}