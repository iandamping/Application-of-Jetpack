package com.example.junemon.risetjetpack.movie.detail

import com.example.junemon.risetjetpack.base.BaseFragmentView
import com.example.junemon.risetjetpack.database.model.DetailMovieModelClass
import com.example.junemon.risetjetpack.database.model.SimilarMovieModelClass

interface DetailPopularMovieView : BaseFragmentView {
    fun getDetailPopularMovie(data: DetailMovieModelClass?)
    fun getSimilarMovie(data: List<SimilarMovieModelClass.Result>?)
}