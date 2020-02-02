package com.annasblackhat.listpaging.paging

import androidx.recyclerview.widget.DiffUtil
import com.annasblackhat.listpaging.gameofthrone.GotHouse
import com.annasblackhat.listpaging.quotes.Quotes

class Comparators {
    companion object {
        val QUOTES_COMPARATOR = object : DiffUtil.ItemCallback<Quotes>() {
            override fun areItemsTheSame(oldItem: Quotes, newItem: Quotes) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Quotes, newItem: Quotes) =
                oldItem == newItem
        }

        val GOT_COMPARATOR = object : DiffUtil.ItemCallback<GotHouse>() {
            override fun areItemsTheSame(oldItem: GotHouse, newItem: GotHouse) =
                oldItem.name == newItem.name

            override fun areContentsTheSame(oldItem: GotHouse, newItem: GotHouse) =
                oldItem == newItem

        }
    }
}