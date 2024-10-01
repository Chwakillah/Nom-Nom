package com.belajar.finalprojectandroidbeginner

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FoodItem(
    val title: String,
    val description: String,
    val review: String,
    val rating: Float,
    val image: Int
) : Parcelable
