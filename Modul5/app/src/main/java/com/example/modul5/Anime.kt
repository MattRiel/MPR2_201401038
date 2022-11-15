package com.example.modul5

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Anime(
    var name : String,
    var description : String,
    var photo : Int,
) : Parcelable
