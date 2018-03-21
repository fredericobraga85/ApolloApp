package com.apolloapp.main

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.apolloapp.R
import com.apolloapp.block.BlockAdapter
import com.apolloapp.block.BlockModel
import com.apolloapp.feed.FeedAdapter
import com.apolloapp.feed.FeedModel
import com.apolloapp.story.StoryAdapter
import com.apolloapp.story.StoryModel
import kotlinx.android.synthetic.main.activity_home.*

class MainActivity : MainView, AppCompatActivity() {



    val presenter = MainPresenterImpl(this)
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        when (item.itemId) {
            R.id.navigation_feeds -> {

                presenter.getFeeds()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_blocks -> {
                presenter.getBlocks()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_stories -> {
                presenter.getStories()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val mLayoutManager = LinearLayoutManager(this);
        recyclerView.layoutManager = mLayoutManager

        presenter.getFeeds()
    }


    override fun populateFeeds(list: List<FeedModel>) {

        if(recyclerView?.adapter == null) {

            recyclerView?.adapter = FeedAdapter(list)
        }
        else
        {
            if(recyclerView.adapter is FeedAdapter) {

                (recyclerView.adapter as FeedAdapter).updateList(list)
            }
            else
            {
                recyclerView?.adapter = FeedAdapter(list)
            }
        }

    }



    override fun populateBlocks(list: List<BlockModel>) {

        if(recyclerView?.adapter == null) {

            recyclerView?.adapter = BlockAdapter(list)
        }
        else
        {
            if(recyclerView.adapter is BlockAdapter) {

                (recyclerView.adapter as BlockAdapter).updateList(list)
            }
            else
            {
                recyclerView?.adapter = BlockAdapter(list)
            }
        }

    }

    override fun populateStories(list: List<StoryModel>) {

        if(recyclerView?.adapter == null) {

            recyclerView?.adapter = StoryAdapter(list)
        }
        else
        {
            if(recyclerView.adapter is StoryAdapter) {

                (recyclerView.adapter as StoryAdapter).updateList(list)
            }
            else
            {
                recyclerView?.adapter = StoryAdapter(list)
            }
        }
    }



    override fun showErrorFeeds() {
        Toast.makeText(this,getString(R.string.error_feeds), Toast.LENGTH_SHORT).show()
    }

    override fun showErrorBlocks() {
        Toast.makeText(this,getString(R.string.error_blocks), Toast.LENGTH_SHORT).show()
    }

    override fun showErrorStories() {
        Toast.makeText(this,getString(R.string.error_stories), Toast.LENGTH_SHORT).show()
    }


    override fun showProgress() {
        progressBar.visibility = View.VISIBLE


    }

    override fun hideProgess() {
//        progressBar.visibility = View.INVISIBLE
    }

}
