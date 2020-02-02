package com.annasblackhat.listpaging

import com.annasblackhat.listpaging.gameofthrone.GotService
import com.annasblackhat.listpaging.quotes.QuoteService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {

    companion object {
        private const val quoteBaseUrl = "https://programming-quotes-api.herokuapp.com"
        const val gotBaseUrl = "https://www.anapioficeandfire.com/"

        private fun create(baseUrl: String): Retrofit {
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        fun createQuoteService(): QuoteService {
            return create(quoteBaseUrl).create(QuoteService::class.java)
        }

        fun createGotService(): GotService {
            return create(gotBaseUrl).create(GotService::class.java)
        }
    }
}