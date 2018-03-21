package com.apolloapp.block

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.apolloapp.R


import kotlinx.android.synthetic.main.feed_item_view.view.*


/**
 * Created by fredbraga on 20/03/18.
 */

class BlockAdapter(var items: List<BlockModel>?) : RecyclerView.Adapter<BlockAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlockAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.block_item_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() : Int {
        if(items != null)
        {
            return items!!.size
        }

        return 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        return holder.bind(items?.get(position))
    }

    fun updateList(list: List<BlockModel>?)
    {
        this.items = list
        this.notifyDataSetChanged()
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)
    {
        fun bind(item: BlockModel?) =

                with(itemView) {
                    tvName.text = item?.header

                }
    }
}