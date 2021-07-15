package com.example.parcelable

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PersonParcel(
    val name: String?,
    val age: Int?,
    val email: String?,
    val city: String?
) : Parcelable