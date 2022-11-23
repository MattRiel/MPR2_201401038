package com.example.modul6

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Anime(
    var id: Int,
    var name:String?,
    var img:String?

/*    var name : String,
    var description : String,
    var photo : Int,*/
) : Parcelable
