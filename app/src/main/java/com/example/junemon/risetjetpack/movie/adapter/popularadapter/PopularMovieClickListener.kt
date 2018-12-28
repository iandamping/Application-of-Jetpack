package com.example.junemon.risetjetpack.movie.adapter.popularadapter

import android.view.View
import com.example.junemon.risetjetpack.database.model.PopularModelClass

interface PopularMovieClickListener {
    fun onClick(view: View, data: PopularModelClass.Result)
}