package com.annasblackhat.listpaging.paging

import android.view.View

interface NetworkCall<T> {
    fun onSuccess(data: ArrayList<T>)
}

interface ViewModelDataSource<T> {
    fun createCall(page: Int, callInterface: NetworkCall<T>)
}

typealias onBind<T>  = (View, T?, Int) -> Unit
