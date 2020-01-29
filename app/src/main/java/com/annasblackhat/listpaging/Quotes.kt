package com.annasblackhat.listpaging

import com.google.gson.annotations.SerializedName

data class Quotes(
    @SerializedName("author")
    val author: String?,
    @SerializedName("en")
    val en: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("rating")
    val rating: Int?,
    @SerializedName("sr")
    val sr: String?
)