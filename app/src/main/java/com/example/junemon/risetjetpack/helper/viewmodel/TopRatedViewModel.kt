package com.example.junemon.risetjetpack.helper.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.example.junemon.risetjetpack.MainApplication
import com.example.junemon.risetjetpack.database.model.TopRatedModelClass
import com.example.junemon.risetjetpack.helper.datasource.TopratedMovieBoundaryCallback

class TopRatedViewModel(application: Application) : AndroidViewModel(application) {
    private val pageSize = 20
    private val isPlaceHolder = true
    private lateinit var movieList: LiveData<PagedList<TopRatedModelClass.Result>>

    fun getAllMovies(): LiveData<PagedList<TopRatedModelClass.Result>> {
        val config = PagedList.Config.Builder()
                .setEnablePlaceholders(isPlaceHolder)
                .setInitialLoadSizeHint(pageSize)
                .setPageSize(pageSize)
                .build()
        movieList = initDBPagedListBuilder(config).build()
        return movieList
    }

    private fun initDBPagedListBuilder(config: PagedList.Config): LivePagedListBuilder<Int, TopRatedModelClass.Result> {
        val livePageListBuilder = LivePagedListBuilder<Int, TopRatedModelClass.Result>(
                MainApplication.movieDatabaseAcces?.topRatedMovieDao()?.getAllMovies()!!, config)
        livePageListBuilder.setBoundaryCallback(TopratedMovieBoundaryCallback())
        return livePageListBuilder
    }
}