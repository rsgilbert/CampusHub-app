package com.lokech.campushub.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Item(
    val id: String = Date().time.toString(),
    val name: String = "",
    val price: Long = 0L,
    val description: String = "",
    val displayPicture: String = "",
    val pictures: List<String> = emptyList()
) : Parcelable
