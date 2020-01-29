package com.annasblackhat.listpaging

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class PagingViewModel: ViewModel(){

    private val executor: ExecutorService = Executors.newFixedThreadPool(5)
    private val dataFactory = QuoteDataSourceFactory()

    private val pageConfig = PagedList.Config.Builder()
        .setEnablePlaceholders(false)
        .setInitialLoadSizeHint(10)
        .setPageSize(20)
        .build()

    val quoteLiveData: LiveData<PagedList<Quotes>> = LivePagedListBuilder(dataFactory, pageConfig)
        .setFetchExecutor(executor)
        .build()


}