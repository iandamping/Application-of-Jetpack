package com.example.junemon.risetjetpack.networking

import com.example.junemon.risetjetpack.database.model.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @GET(ApiConfig.getPopularMovie)
    fun getPopularMovieData(@Query("api_key") apiKey: String, @Query("page") page: Int): Observable<PopularModelClass>

    @GET(ApiConfig.getTopRatedMovie)
    fun getTopRatedMovieData(@Query("api_key") apiKey: String, @Query("page") page: Int): Observable<TopRatedModelClass>

    @GET(ApiConfig.getUpComingMovie)
    fun getUpComingMovieData(@Query("api_key") apiKey: String, @Query("page") page: Int): Observable<UpcomingModelClass>

    @GET(ApiConfig.getDetailMovie + "{movie}")
    fun getDetailMovieData(@Path("movie") movieId: Int?, @Query("api_key") apiKey: String?): Observable<DetailMovieModelClass>

    @GET(ApiConfig.getSimilarMovie + "{movie_id}/similar")
    fun getSimilarMovieData(@Path("movie_id") movieId: Int?, @Query("api_key") apiKey: String): Observable<SimilarMovieModelClass>
}