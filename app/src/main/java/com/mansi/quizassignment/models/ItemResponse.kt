package com.mansi.quizassignment.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemResponse (
    @field:SerializedName("data")  val data : List<Data>,
   @field:SerializedName("array_count") val arrayCount : Int): Parcelable