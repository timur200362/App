package com.example.translator.data.remote.response


import com.google.gson.annotations.SerializedName

data class TranslationResponseItem(
    @SerializedName("id")
    val id: Int,
    @SerializedName("meanings")
    val meanings: List<Meaning>,
    @SerializedName("text")
    val text: String
)