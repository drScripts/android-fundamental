package com.example.mysubmission

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PersonModel (
    var username : String = "",
    var name : String = "",
    var location : String = "",
    var repository : Int = 0,
    var company : String = "",
    var following : Int = 0,
    var followers : Int = 0,
    var image : Int = 0
        ):Parcelable