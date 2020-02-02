package com.annasblackhat.listpaging.quotes

import com.annasblackhat.listpaging.quotes.Quotes
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface QuoteService {

    @GET("quotes/page/{page}")
    fun getQuotesPaging(@Path("page") page: Int): Call<ArrayList<Quotes>>

}