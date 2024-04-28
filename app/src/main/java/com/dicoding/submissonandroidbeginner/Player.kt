package com.dicoding.submissonandroidbeginner


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Player(
    val name: String,
    val description: String,
    val rate : String,
    val photo: Int
) : Parcelable
