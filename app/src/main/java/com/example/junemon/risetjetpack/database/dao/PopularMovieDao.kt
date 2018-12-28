package com.example.junemon.risetjetpack.database.dao

import android.arch.lifecycle.LiveData
import android.arch.paging.DataSource
import android.arch.persistence.room.*
import com.example.junemon.risetjetpack.database.model.PopularModelClass

@Dao
interface PopularMovieDao {
    @Query("SELECT * FROM popular_movie_model")
    fun loadAllPopularMovie(): LiveData<List<PopularModelClass.Result>>

    @Query("SELECT * FROM popular_movie_model WHERE id_popularMovie = :id")
    fun loadPopularMovieById(id: Int?): LiveData<PopularModelClass.Result>

    @Insert
    fun insertPopularMovie(input_popularMovie: List<PopularModelClass.Result>?)

    @Query("SELECT * FROM popular_movie_model")
    fun getAllMovies(): DataSource.Factory<Int, PopularModelClass.Result>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updatePopularMovie(update_popularMovie: PopularModelClass.Result?)

    @Query("DELETE FROM popular_movie_model")
    fun deleteAllData()
}