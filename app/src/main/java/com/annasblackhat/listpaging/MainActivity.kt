package com.annasblackhat.listpaging

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.annasblackhat.listpaging.gameofthrone.GameOfThroneHousesActivity
import com.annasblackhat.listpaging.paging.Comparators
import com.annasblackhat.listpaging.paging.PagingAdapter
import com.annasblackhat.listpaging.quotes.QuoteViewModel
import com.annasblackhat.listpaging.quotes.QuotesActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_example_1.setOnClickListener { startActivity(Intent(this, QuotesActivity::class.java)) }
        btn_example_2.setOnClickListener { startActivity(Intent(this, GameOfThroneHousesActivity::class.java)) }
    }
}
