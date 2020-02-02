package com.annasblackhat.listpaging.gameofthrone

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

class GotViewModel : ViewModel() {

    private val executor: ExecutorService = Executors.newFixedThreadPool(5)
    private val dataFactory = PagingDataSourceFactory(loadHouses())

    private val pageConfig = PagedList.Config.Builder()
        .setEnablePlaceholders(false)
        .setInitialLoadSizeHint(10)
        .setPageSize(20)
        .build()

    val houseLiveData: LiveData<PagedList<GotHouse>> = LivePagedListBuilder(dataFactory, pageConfig)
        .setFetchExecutor(executor)
        .build()


    private fun loadHouses(): ViewModelDataSource<GotHouse> {
        return object : ViewModelDataSource<GotHouse> {
            override fun createCall(page: Int, callInterface: NetworkCall<GotHouse>) {
                viewModelScope.launch {
                    try {
                        val resp = RetrofitBuilder.createGotService().getGotHouses(page).await()
                        callInterface.onSuccess(resp)
                    } catch (e: Exception) {
                    }
                }
            }
        }
    }

}
