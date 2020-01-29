package com.annasblackhat.listpaging

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface QuoteService {

    @GET("quotes/page/{page}")
    fun getQuotesPaging(@Path("page") page: Int): Call<ArrayList<Quotes>>

}