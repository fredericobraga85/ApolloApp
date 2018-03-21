package com.apolloapp.repository

import com.apolloapp.block.BlockModel
import com.apolloapp.feed.FeedModel
import com.apolloapp.story.StoryModel
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.rx2.Rx2Apollo
import io.reactivex.Observable
import com.apollographql.apollo.CustomTypeAdapter
import type.CustomType
import java.text.ParseException
import java.util.*


class GraphQLRepositoryImpl: Repository {


    var customTypeAdapter: CustomTypeAdapter<String> = object : CustomTypeAdapter<String> {
        override fun decode(value: String): String {
            try {
                return value
            } catch (e: ParseException) {
                throw RuntimeException(e)
            }

        }

        override fun encode(value: String): String {
            return value
        }
    }




    override fun getFeeds(): Observable<List<FeedModel>>? {

        return callFeedQuery()
                .flatMap {

                    var listFeeds = ArrayList<FeedModel>()

                    it.data()?.feeds()?.map { feed ->
                        val feedModel = FeedModel(feed.name(), feed.url(), feed.isDefault, feed._id())
                        listFeeds.add(feedModel)
                    }

                    Observable.just(listFeeds)
                }
    }




    override fun getBlocks(): Observable<List<BlockModel>>? {
        return callBlockQuery()
                .flatMap {

                    var list = ArrayList<BlockModel>()

                    it.data()?.blocks()?.map { b ->

                        val model = BlockModel(b.name(), b.header(),b.type(), b.order(), b.state(), b._id())
                        list.add(model)
                    }

                    Observable.just(list)
                }
    }

    override fun getStories(): Observable<List<StoryModel>>? {
        return callStoryQuery()
                .flatMap {

                    var list = ArrayList<StoryModel>()

                    it.data()?.stories()?.map { s ->

                        val model = StoryModel(s.uuid(), s.title(), s.subtitle(), published = s.published(), image=s.image(), _id= s._id(), viewers=s.viewers(), url=s.url())
                        list.add(model)
                    }

                    Observable.just(list)
                }


    }

    private fun getApolloClient(): ApolloClient {
        val apolloClient = ApolloClient
                .builder()
                .serverUrl("http://na.herald.riotgames.com/graphql")
                .addCustomTypeAdapter(CustomType.MONGOID, customTypeAdapter)
                .addCustomTypeAdapter(CustomType.DATE, customTypeAdapter)
                .build()

        return apolloClient

    }

    private fun callFeedQuery() : Observable<Response<FeedQuery.Data>>{

        val apolloCall = getApolloClient().query(FeedQuery.builder().build())
        val feedObs = Rx2Apollo.from(apolloCall)

        return feedObs
    }

    private fun callBlockQuery() : Observable<Response<BlockQuery.Data>>{

        val apolloCall = getApolloClient().query(BlockQuery.builder().build())
        val blockObs = Rx2Apollo.from(apolloCall)

        return blockObs
    }

    private fun callStoryQuery() : Observable<Response<StorySimpleQuery.Data>>{

        val apolloCall = getApolloClient().query(StorySimpleQuery.builder().build())
        val obs = Rx2Apollo.from(apolloCall)

        return obs
    }






}


