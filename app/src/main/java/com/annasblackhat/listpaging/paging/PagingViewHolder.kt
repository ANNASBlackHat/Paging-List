package com.annasblackhat.listpaging.paging

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.annasblackhat.listpaging.BR

class PagingViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding: ViewDataBinding? = DataBindingUtil.bind(itemView)

    fun bind(data: Any?) {
        println("[[PAGING]] bind... $data")
        binding?.setVariable(BR.model, data)
        binding?.executePendingBindings()
    }

}