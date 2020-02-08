package com.annasblackhat.listpaging

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class PagingAdapter : PagedListAdapter<Quotes,  RecyclerView.ViewHolder>(QUOTES_COMPARATOR) {

    private var networkState: NetworkState? = null
    private val TYPE_NETWORK_STATE = 0
    private val TYPE_ITEM = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if(viewType == TYPE_NETWORK_STATE){
            NetworkViewHolder(parent)
        }else{
            PagingViewHolder(parent)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is PagingViewHolder){
            holder.bind(getItem(position))
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (hasExtraRow() && position == itemCount - 1) {
            TYPE_NETWORK_STATE
        } else {
            TYPE_ITEM
        }
    }

    private fun hasExtraRow() = networkState != null && networkState != NetworkState.LOADED

    fun setNetworkState(networkState: NetworkState?){
        val previousState = this.networkState
        val hadExtraRow = hasExtraRow()
        this.networkState = networkState
        val hasExtraRow = hasExtraRow()

        if(hadExtraRow != hasExtraRow){
            if(hadExtraRow){
                notifyItemRemoved(super.getItemCount())
            }else{
                notifyItemInserted(super.getItemCount())
            }
        }else if(hasExtraRow && previousState != networkState){
            notifyItemChanged(itemCount - 1)
        }
    }


    companion object {
        private val QUOTES_COMPARATOR = object : DiffUtil.ItemCallback<Quotes>() {
            override fun areItemsTheSame(oldItem: Quotes, newItem: Quotes) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Quotes, newItem: Quotes) = oldItem == newItem
        }
    }

}