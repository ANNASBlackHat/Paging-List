package com.annasblackhat.listpaging.gameofthrone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.annasblackhat.listpaging.R
import com.annasblackhat.listpaging.paging.Comparators
import com.annasblackhat.listpaging.paging.PagingAdapter
import kotlinx.android.synthetic.main.activity_game_of_throne_houses.*

class GameOfThroneHousesActivity : AppCompatActivity() {

    private val viewModel: GotViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_of_throne_houses)

        val adapter = PagingAdapter(R.layout.list_item_houses, Comparators.GOT_COMPARATOR)
        recview_got.adapter = adapter
        viewModel.houseLiveData.observe(this, Observer {
            adapter.submitList(it)
        })
    }
}
