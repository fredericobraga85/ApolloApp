package com.apolloapp.feed

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.apolloapp.R
import kotlinx.android.synthetic.main.feed_item_view.view.*


/**
 * Created by fredbraga on 20/03/18.
 */

class FeedAdapter(var items: List<FeedModel>?) : RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedAdapter.FeedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.feed_item_view, parent, false)
        return FeedViewHolder(view)
    }

    override fun getItemCount() : Int {
        if(items != null)
        {
            return items!!.size
        }

        return 0
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {

        return holder.bind(items?.get(position))
    }

    fun updateList(list: List<FeedModel>?)
    {
        this.items = list
        this.notifyDataSetChanged()
    }

    class FeedViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)
    {
        fun bind(item: FeedModel?) =

                with(itemView) {
                    tvName.text = item?.name

                }
    }
}