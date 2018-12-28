package com.example.junemon.risetjetpack

import android.app.Application
import com.example.junemon.risetjetpack.database.MovieDatabase
import com.example.junemon.risetjetpack.networking.ApiClient

class MainApplication : Application() {
    companion object {
        var movieDatabaseAcces: MovieDatabase? = null
        val getMovieData by lazy {
            ApiClient.create()
        }
    }

    override fun onCreate() {
        super.onCreate()
        movieDatabaseAcces = MovieDatabase.getInstace(applicationContext)
    }
}