package com.annasblackhat.listpaging.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.annasblackhat.listpaging.R
import com.annasblackhat.listpaging.paging.Comparators
import com.annasblackhat.listpaging.paging.PagingAdapter
import kotlinx.android.synthetic.main.activity_quotes.*

class QuotesActivity : AppCompatActivity() {

    private val viewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)

        val adapter = PagingAdapter(
            R.layout.list_item_quotes,
            Comparators.QUOTES_COMPARATOR
        ) { view, model, position ->
            view.setOnClickListener {
                Toast.makeText(
                    this,
                    "you are clicking ${model?.author} on position : $position",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        recview_quote.adapter = adapter
        viewModel.quoteLiveData.observe(this, Observer {
            println("[[PAGING]] observe paging")
            adapter.submitList(it)
        })
    }
}
