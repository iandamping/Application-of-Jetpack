package com.example.junemon.risetjetpack.database.dao

import android.arch.lifecycle.LiveData
import android.arch.paging.DataSource
import android.arch.persistence.room.*
import com.example.junemon.risetjetpack.database.model.TopRatedModelClass

@Dao
interface TopRatedMovieDao {
    @Query("SELECT * FROM toprated_movie_model")
    fun loadAllTopRatedMovie(): LiveData<List<TopRatedModelClass.Result>>

    @Query("SELECT * FROM toprated_movie_model WHERE id_popularMovie = :id")
    fun loadTopRatedMovieById(id: Int?): LiveData<TopRatedModelClass.Result>

    @Insert
    fun insertTopRatedMovie(input_toprated: List<TopRatedModelClass.Result>?)

    @Query("SELECT * FROM toprated_movie_model")
    fun getAllMovies(): DataSource.Factory<Int, TopRatedModelClass.Result>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateTopRatedMovie(update_toprated: TopRatedModelClass.Result?)

    @Query("DELETE FROM toprated_movie_model")
    fun deleteAllData()
}