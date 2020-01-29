package com.annasblackhat.listpaging

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource

class QuoteDataSourceFactory(val viewModel: PagingViewModel) : DataSource.Factory<Int, Quotes>() {

    val sourceLiveData = MutableLiveData<QuoteDataSource>()
    var latestSource: QuoteDataSource? = null

    override fun create(): DataSource<Int, Quotes> {
        latestSource = QuoteDataSource(viewModel)
        sourceLiveData.postValue(latestSource)
        return latestSource!!
    }


}