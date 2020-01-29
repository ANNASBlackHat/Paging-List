package com.annasblackhat.listpaging

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class PagingViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.list_item_quotes, parent, false)
) {

    private val binding: ViewDataBinding? = DataBindingUtil.bind(itemView)

    fun bind(quotes: Quotes?) {
        println("[[PAGING]] bind... $quotes")
        binding?.setVariable(BR.model, quotes)
        binding?.executePendingBindings()
    }

}