package com.annasblackhat.listpaging.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource

class PagingDataSourceFactory<T>(private val viewModel: ViewModelDataSource<T>) :
    DataSource.Factory<Int, T>() {

    private val sourceLiveData = MutableLiveData<PagingDataSource<T>>()
    var latestSource: PagingDataSource<T>? = null

    override fun create(): DataSource<Int, T> {
        latestSource =
            PagingDataSource(viewModel)
        sourceLiveData.postValue(latestSource)
        return latestSource!!
    }


}