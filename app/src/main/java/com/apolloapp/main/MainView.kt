package com.apolloapp.main

import com.apolloapp.block.BlockModel
import com.apolloapp.feed.FeedModel
import com.apolloapp.story.StoryModel

interface MainView {

    fun populateFeeds(list: List<FeedModel> )
    fun populateBlocks(list: List<BlockModel> )
    fun populateStories(list: List<StoryModel> )

    fun showErrorFeeds()
    fun showErrorBlocks()
    fun showErrorStories()

    fun showProgress()
    fun hideProgess()



}
