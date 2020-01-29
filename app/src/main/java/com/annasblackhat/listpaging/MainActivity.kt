package com.annasblackhat.listpaging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel: PagingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = PagingAdapter()
        recview.adapter = adapter

        viewModel.quoteLiveData.observe(this, Observer {
            println("[[PAGING]] observe paging")
            adapter.submitList(it)
        })
    }
}
