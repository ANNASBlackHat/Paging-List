package com.annasblackhat.listpaging

interface NetworkCall<T> {
    fun onSuccess(data: ArrayList<T>)
}