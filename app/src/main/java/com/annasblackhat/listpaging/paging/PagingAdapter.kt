package com.annasblackhat.listpaging.paging

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil

class PagingAdapter<T>(
    @field:LayoutRes private var layoutId: Int,
    COMPARATOR: DiffUtil.ItemCallback<T>,
    private val onBindItem: onBind<T>? = null
) :
    PagedListAdapter<T, PagingViewHolder>(COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagingViewHolder =
        PagingViewHolder(
            LayoutInflater.from(parent.context).inflate(
                layoutId,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: PagingViewHolder, position: Int) {
        holder.bind(getItem(position))
        onBindItem?.let { it(holder.itemView, getItem(position), holder.adapterPosition) }
    }

}

