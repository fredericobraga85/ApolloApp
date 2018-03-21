package com.apolloapp.repository

import com.apolloapp.block.BlockModel
import com.apolloapp.feed.FeedModel
import com.apolloapp.story.StoryModel
import io.reactivex.Observable

interface Repository {

    fun getFeeds() : Observable<List<FeedModel>>?
    fun getBlocks(): Observable<List<BlockModel>>?
    fun getStories(): Observable<List<StoryModel>>?


}
