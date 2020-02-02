package com.annasblackhat.listpaging.quotes

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.annasblackhat.listpaging.RetrofitBuilder
import com.annasblackhat.listpaging.paging.NetworkCall
import com.annasblackhat.listpaging.paging.PagingDataSourceFactory
import com.annasblackhat.listpaging.paging.ViewModelDataSource
import kotlinx.coroutines.launch
import retrofit2.await
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class QuoteViewModel : ViewModel() {

    private val executor: ExecutorService = Executors.newFixedThreadPool(5)
    private val dataFactory =
        PagingDataSourceFactory(loadData())

    private val pageConfig = PagedList.Config.Builder()
        .setEnablePlaceholders(false)
        .setInitialLoadSizeHint(10)
        .setPageSize(20)
        .build()

    val quoteLiveData: LiveData<PagedList<Quotes>> = LivePagedListBuilder(dataFactory, pageConfig)
        .setFetchExecutor(executor)
        .build()

    private fun loadData(): ViewModelDataSource<Quotes> {
        return object :
            ViewModelDataSource<Quotes> {
            override fun createCall(page: Int, callListener: NetworkCall<Quotes>) {
                viewModelScope.launch {
                    try {
                        val resp =
                            RetrofitBuilder.createQuoteService()
                                .getQuotesPaging(page).await()
                        callListener.onSuccess(resp)
                    } catch (e: Exception) {
                        println("[[PAGING]] load from server error: $e")
                    }
                }
            }
        }
    }
}