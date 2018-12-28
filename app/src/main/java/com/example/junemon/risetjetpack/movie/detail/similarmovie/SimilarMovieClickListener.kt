package com.example.junemon.risetjetpack.movie.detail.similarmovie

import android.view.View
import com.example.junemon.risetjetpack.database.model.SimilarMovieModelClass

interface SimilarMovieClickListener {
    fun onClick(view: View, data: SimilarMovieModelClass.Result)
}