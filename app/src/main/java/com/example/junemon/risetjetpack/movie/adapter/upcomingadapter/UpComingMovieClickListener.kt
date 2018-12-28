package com.example.junemon.risetjetpack.movie.adapter.upcomingadapter

import android.view.View
import com.example.junemon.risetjetpack.database.model.UpcomingModelClass

interface UpComingMovieClickListener {
    fun onClick(view: View, data: UpcomingModelClass.Result)
}