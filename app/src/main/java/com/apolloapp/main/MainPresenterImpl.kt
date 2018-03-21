package com.apolloapp.main

import android.util.Log
import com.apolloapp.repository.GraphQLRepositoryImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by fredbraga on 20/03/18.
 */


class MainPresenterImpl(val view: MainView): MainPresenter {

    private val repository = GraphQLRepositoryImpl()

    override fun getFeeds()
    {
        view.showProgress()

        repository.getFeeds()?.subscribeOn(Schedulers.io())?.observeOn(AndroidSchedulers.mainThread())?.subscribe(
                { view.populateFeeds(it)},
                {
                    Log.e("getFeeds" ,"Error:" + it.message)
                    view.showErrorFeeds()
                    view.hideProgess()
                },
                {
                    Log.d("getFeeds" , "completed")
                    view.hideProgess()
                }
        )
        ?: run {
            view.showErrorFeeds()
            view.hideProgess()
        }
    }

    override fun getBlocks() {

        view.showProgress()

        repository.getBlocks()?.subscribeOn(Schedulers.io())?.observeOn(AndroidSchedulers.mainThread())?.subscribe(
                { view.populateBlocks(it)},
                {
                    Log.e("getBlocks" ,"Error:" + it.message)
                    view.showErrorBlocks()
                    view.hideProgess()
                },
                {
                    Log.d("getBlocks" , "completed")
                    view.hideProgess()
                }
        )
        ?: run {
            view.showErrorBlocks()
            view.hideProgess()
        }

    }

    override fun getStories() {

        view.showProgress()

        repository.getStories()?.subscribeOn(Schedulers.io())?.observeOn(AndroidSchedulers.mainThread())?.subscribe(
                { view.populateStories(it)},
                {
                    Log.e("getStories" ,"Error:" + it.message)
                    view.showErrorStories()
                    view.hideProgess()
                },
                {
                    Log.d("getStories" , "completed")
                    view.hideProgess()
                }
        )
                ?: run {
                    view.showErrorStories()
                    view.hideProgess()
                }
    }


}

