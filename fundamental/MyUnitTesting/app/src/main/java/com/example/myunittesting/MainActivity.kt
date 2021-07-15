package com.example.myunittesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var edtWidth : EditText
    private lateinit var edtHeight : EditText
    private lateinit var edtLength : EditText
    private lateinit var btnCalculateVolume : Button
    private lateinit var btnCalculateSurface : Button
    private lateinit var btnCalculateCircumference : Button
    private lateinit var btnSave : Button
    private lateinit var result : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = MainViewModel(CuboidModel())

        edtHeight = findViewById(R.id.edt_height)
        edtWidth = findViewById(R.id.edt_width)
        edtLength = findViewById(R.id.edt_length)
        btnCalculateCircumference = findViewById(R.id.btn_calculate_circumference)
        btnCalculateVolume = findViewById(R.id.btn_calculate_volume)
        btnSave = findViewById(R.id.btn_save)
        btnCalculateSurface = findViewById(R.id.btn_calculate_surface_area)
        result = findViewById(R.id.tv_result)

        btnSave.setOnClickListener(this)
        btnCalculateCircumference.setOnClickListener(this)
        btnCalculateVolume.setOnClickListener(this)
        btnCalculateSurface.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val length = edtLength.text.toString().trim()
        val width = edtWidth.text.toString().trim()
        val height = edtHeight.text.toString().trim()

        when{
            length.isEmpty() -> edtLength.error = "Field Ini Tidak Boleh Kosong"
            width.isEmpty()  -> edtWidth.error = "Field Ini Tidak Boleh Kosong"
            height.isEmpty() -> edtHeight.error = "Field Ini Tidak Boleh Kosong"
            else -> {
                when(v?.id){
                    R.id.btn_save -> {
                        mainViewModel.save(length.toDouble(),width.toDouble(),height.toDouble())
                        visible()
                    }
                    R.id.btn_calculate_circumference -> {
                        result.text = mainViewModel.getCircumFarce().toString().trim()
                        gone()
                    }
                    R.id.btn_calculate_surface_area -> {
                        result.text = mainViewModel.getSurfaceArea().toString().trim()
                        gone()
                    }
                    R.id.btn_calculate_volume -> {
                        result.text = mainViewModel.getVolume().toString().trim()
                        gone()
                    }
                }
            }
        }
    }

    private fun visible(){
        btnCalculateSurface.visibility = View.VISIBLE
        btnCalculateVolume.visibility = View.VISIBLE
        btnCalculateCircumference.visibility = View.VISIBLE
        btnSave.visibility = View.GONE
    }

    private fun gone(){
        btnCalculateSurface.visibility = View.GONE
        btnCalculateVolume.visibility = View.GONE
        btnCalculateCircumference.visibility = View.GONE
        btnSave.visibility = View.VISIBLE
    }
}









