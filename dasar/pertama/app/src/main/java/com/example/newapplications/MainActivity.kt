package com.example.newapplications

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var edtLength : EditText
    private lateinit var edtWidth : EditText
    private lateinit var edtHeight : EditText
    private lateinit var btnCalculate : Button
    private lateinit var resultText : TextView

    companion object{
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtLength = findViewById(R.id.edt_length)
        edtWidth = findViewById(R.id.edt_width)
        edtHeight = findViewById(R.id.edt_height)
        btnCalculate = findViewById(R.id.btn_calculate)
        resultText = findViewById(R.id.result_text)

        btnCalculate.setOnClickListener(this)

        if (savedInstanceState != null){
            val result = savedInstanceState.get("state_result")
            resultText.text = result.toString()
        }

    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_calculate){
            val inputLength = edtLength.text.toString().trim()
            val inputWidth = edtWidth.text.toString().trim()
            val inputHeight = edtHeight.text.toString().trim()

            var edtTextEmpty = false

            if(inputLength.isEmpty() || inputLength.isBlank()){
                edtTextEmpty = true
                edtLength.error = "Field ini tidak boleh kosong"
            }

            if(inputHeight.isEmpty() || inputHeight.isBlank()){
                edtTextEmpty = true
                edtHeight.error = "Field ini tidak boleh kosong"
            }

            if(inputWidth.isEmpty() || inputWidth.isBlank()){
                edtTextEmpty = true
                edtWidth.error = "Field ini tidak boleh kosong"
            }

            if(!edtTextEmpty){
                val volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                resultText.text = "Result: ${volume.toString()}"
            }
        }
    }

    // untuk ngesave dii instance state
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT,resultText.text.toString())
    }



}



