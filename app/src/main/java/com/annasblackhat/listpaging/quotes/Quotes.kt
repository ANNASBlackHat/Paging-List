package com.annasblackhat.listpaging.quotes

import com.google.gson.annotations.SerializedName

data class Quotes(
    @SerializedName("author")
    val author: String?,
    @SerializedName("en")
    val en: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("rating")
    val rating: Double?,
    @SerializedName("sr")
    val sr: String?
)