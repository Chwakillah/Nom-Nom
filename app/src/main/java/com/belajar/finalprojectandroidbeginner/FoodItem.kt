package com.belajar.finalprojectandroidbeginner

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FoodItem(
    val title: String,
    val description: String,
    val image: Int
) : Parcelable
