package com.annasblackhat.listpaging

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil

class PagingAdapter : PagedListAdapter<Quotes, PagingViewHolder>(QUOTES_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagingViewHolder =
        PagingViewHolder(parent)

    override fun onBindViewHolder(holder: PagingViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    companion object {
        private val QUOTES_COMPARATOR = object : DiffUtil.ItemCallback<Quotes>() {
            override fun areItemsTheSame(oldItem: Quotes, newItem: Quotes) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Quotes, newItem: Quotes) = oldItem == newItem
        }
    }

}