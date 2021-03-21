package com.mansi.quizassignment.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class McqoptionSet (
        @field:SerializedName("is_correct") val is_correct : Boolean,
        @field:SerializedName("id") val id : Int,
        @field:SerializedName("value") val value : String
        ): Parcelable
