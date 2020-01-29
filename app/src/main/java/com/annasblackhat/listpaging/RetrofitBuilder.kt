package com.annasblackhat.listpaging

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {

    companion object {
        fun create(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://programming-quotes-api.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        fun createQuoteService(): QuoteService {
            return create().create(QuoteService::class.java)
        }
    }
}