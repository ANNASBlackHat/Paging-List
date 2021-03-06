package com.annasblackhat.listpaging

import androidx.paging.PageKeyedDataSource

class QuoteDataSource : PageKeyedDataSource<Int, Quotes>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Quotes>
    ) {
        println("[[PAGING]] load initial.....")
        val quotes = ArrayList<Quotes>()
        for (i in 1..10) {
            quotes.add(Quotes("unknown", "This is quote no $i - page 1", "$i", 5, ""))
        }

        callback.onResult(quotes, null, 2)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Quotes>) {
        println("[[PAGING]] load after.... page ${params.key}")
        val quotes = ArrayList<Quotes>()
        val numStart = (params.key-1) * 10
        for (i in numStart..(numStart + 10)) {
            quotes.add(Quotes("unknown", "This is quote no $i - page ${params.key}", "$i", 5, ""))
        }
        callback.onResult(quotes, params.key + 1)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Quotes>) {
        println("[[PAGING]] load before.... page ${params.key}")
    }
}