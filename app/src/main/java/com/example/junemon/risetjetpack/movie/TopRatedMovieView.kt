package com.example.junemon.risetjetpack.movie

import android.arch.paging.PagedList
import com.example.junemon.risetjetpack.base.BaseFragmentView
import com.example.junemon.risetjetpack.database.model.PopularModelClass
import com.example.junemon.risetjetpack.database.model.TopRatedModelClass
import com.example.junemon.risetjetpack.database.model.UpcomingModelClass

interface TopRatedMovieView : BaseFragmentView {
    fun getAllTopRatedMovieData(allData: List<TopRatedModelClass.Result>?)
    fun getAllPopularMovieData(allData: PagedList<PopularModelClass.Result>?)
    fun getAllUpcomingMovieData(allData: List<UpcomingModelClass.Result>?)
}