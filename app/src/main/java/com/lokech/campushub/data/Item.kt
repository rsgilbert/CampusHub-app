package com.lokech.campushub.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item(
    val name: String = "",
    val price: Long = 0L,
    val description: String = "",
    val displayPicture: String = "",
    val pictures: List<String> = emptyList()
) : Parcelable