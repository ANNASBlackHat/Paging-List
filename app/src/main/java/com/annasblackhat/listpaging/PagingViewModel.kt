package com.annasblackhat.listpaging

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import kotlinx.coroutines.launch
import retrofit2.await
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import kotlin.coroutines.suspendCoroutine

class PagingViewModel : ViewModel() {

    private val executor: ExecutorService = Executors.newFixedThreadPool(5)
    private val dataFactory = QuoteDataSourceFactory(this)

    private val pageConfig = PagedList.Config.Builder()
        .setEnablePlaceholders(false)
        .setInitialLoadSizeHint(10)
        .setPageSize(20)
        .build()

    val quoteLiveData: LiveData<PagedList<Quotes>> = LivePagedListBuilder(dataFactory, pageConfig)
        .setFetchExecutor(executor)
        .build()

    private var _networkState = MutableLiveData<NetworkState>()
    val networkState: LiveData<NetworkState>
        get() = _networkState


    fun loadQuotes(page: Int, networkCall: NetworkCall<Quotes>) {
        viewModelScope.launch {
            _networkState.value = NetworkState.LOADING
            try {
                val resp = RetrofitBuilder.createQuoteService().getQuotesPaging(page).await()
                networkCall.onSuccess(resp)
                _networkState.value = NetworkState.LOADED
            } catch (e: Exception) {
                println("[[PAGING]] load from server error: $e")
                _networkState.value = NetworkState.error(e.message)
            }
        }
    }
}