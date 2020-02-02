package com.annasblackhat.listpaging.gameofthrone

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GotService {

    @GET("api/houses")
    fun getGotHouses(@Query("page") page: Int): Call<ArrayList<GotHouse>>
}