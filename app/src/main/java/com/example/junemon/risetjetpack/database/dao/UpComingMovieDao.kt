package com.example.junemon.risetjetpack.database.dao

import android.arch.lifecycle.LiveData
import android.arch.paging.DataSource
import android.arch.persistence.room.*
import com.example.junemon.risetjetpack.database.model.UpcomingModelClass

@Dao
interface UpComingMovieDao {
    @Query("SELECT * FROM upcoming_movie_model")
    fun loadAllUpComingMovie(): LiveData<List<UpcomingModelClass.Result>>

    @Query("SELECT * FROM upcoming_movie_model WHERE id_popularMovie = :id")
    fun loadUpComingMovieById(id: Int?): LiveData<UpcomingModelClass.Result>

    @Insert
    fun insertUpComingMovie(input_toprated: List<UpcomingModelClass.Result>?)

    @Query("SELECT * FROM upcoming_movie_model")
    fun getAllMovies(): DataSource.Factory<Int, UpcomingModelClass.Result>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateUpComingMovie(update_toprated: UpcomingModelClass.Result?)

    @Query("DELETE FROM upcoming_movie_model")
    fun deleteAllData()
}