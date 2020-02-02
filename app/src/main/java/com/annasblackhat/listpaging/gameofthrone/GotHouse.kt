package com.annasblackhat.listpaging.gameofthrone


import com.google.gson.annotations.SerializedName

data class GotHouse(
    @SerializedName("coatOfArms")
    val coatOfArms: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("region")
    val region: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("words")
    val words: String?
)