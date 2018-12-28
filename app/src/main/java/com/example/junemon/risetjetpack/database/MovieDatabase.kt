package com.example.junemon.risetjetpack.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.junemon.risetjetpack.database.dao.PopularMovieDao
import com.example.junemon.risetjetpack.database.dao.TopRatedMovieDao
import com.example.junemon.risetjetpack.database.dao.UpComingMovieDao
import com.example.junemon.risetjetpack.database.model.PopularModelClass
import com.example.junemon.risetjetpack.database.model.TopRatedModelClass
import com.example.junemon.risetjetpack.database.model.UpcomingModelClass

@Database(entities = arrayOf(PopularModelClass.Result::class, TopRatedModelClass.Result::class, UpcomingModelClass.Result::class), version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {
    companion object {
        private var databaseInstance: MovieDatabase? = null

        fun getInstace(ctx: Context): MovieDatabase? {
            if (databaseInstance == null) {
                synchronized(MovieDatabase::class) {
                    databaseInstance = Room.databaseBuilder(ctx.applicationContext, MovieDatabase::class.java, "Movie Database").build()
                }
            }
            return databaseInstance
        }
    }

    abstract fun popularMovieDao(): PopularMovieDao
    abstract fun topRatedMovieDao(): TopRatedMovieDao
    abstract fun upcomingMovieDao(): UpComingMovieDao
}