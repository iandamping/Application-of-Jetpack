package com.example.junemon.risetjetpack.movie.adapter.topratedadapter

import android.view.View
import com.example.junemon.risetjetpack.database.model.TopRatedModelClass

interface TopRatedMovieClickListener {
    fun onClick(view: View, data: TopRatedModelClass.Result)
}