package com.example.junemon.risetjetpack.networking

class ApiConfig {
    companion object {
        val BASE_URL = "https://api.themoviedb.org/"
        const val getTopRatedMovie = "3/movie/top_rated"
        const val getPopularMovie = "3/movie/popular"
        const val getUpComingMovie = "3/movie/upcoming"
        const val getDetailMovie = "3/movie/"
        const val getSimilarMovie = "3/movie/"
        const val getNowPlayingMovie = "3/movie/now_playing?api_key=9986464dc7ff8e83569e65a98dc7b3b6&language=en-US&page=1"
    }
}