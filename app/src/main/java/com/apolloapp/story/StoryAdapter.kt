package com.apolloapp.story

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.apolloapp.R
import com.apolloapp.block.BlockAdapter
import com.apolloapp.block.BlockModel

import kotlinx.android.synthetic.main.feed_item_view.view.*
import kotlinx.android.synthetic.main.story_item_view.view.*


/**
 * Created by fredbraga on 20/03/18.
 */

class StoryAdapter(var items: List<StoryModel>?) : RecyclerView.Adapter<StoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.story_item_view, parent, false)
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

    fun updateList(list: List<StoryModel>?)
    {
        this.items = list
        this.notifyDataSetChanged()
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)
    {
        fun bind(item: StoryModel?) =

                with(itemView) {
                    tvTitle.text = item?.title
                    tvSubTitile.text = item?.subtitle

                }
    }
}