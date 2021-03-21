package com.mansi.quizassignment.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Data(
        @field:SerializedName("coginitive_level") val coginitiveLevel : String,
        @field:SerializedName("created_at") val createdAt : String,
        @field:SerializedName("marks") val marks : Int,
        @field:SerializedName("id") val id : Int,
        @field:SerializedName("question_type") val questionType : String,
        @field:SerializedName("text") val text : String,
        @field:SerializedName("mcqoption_set") val mcqoptionSet : List<McqoptionSet>,
        ): Parcelable