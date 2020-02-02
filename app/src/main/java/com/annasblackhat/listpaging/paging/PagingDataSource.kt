package com.annasblackhat.listpaging.paging

import androidx.paging.PageKeyedDataSource

class PagingDataSource<T>(private val viewModel: ViewModelDataSource<T>) :
    PageKeyedDataSource<Int, T>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, T>
    ) {
        println("[[PAGING]] load initial.....")
        viewModel.createCall(1, object : NetworkCall<T> {
            override fun onSuccess(data: ArrayList<T>) {
                callback.onResult(data, null, 2)
            }

        })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, T>) {
        println("[[PAGING]] load after.... page ${params.key}")
        viewModel.createCall(params.key, object : NetworkCall<T> {
            override fun onSuccess(data: ArrayList<T>) {
                callback.onResult(data, params.key + 1)
            }
        })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, T>) {
        println("[[PAGING]] load before.... page ${params.key}")
    }
}
