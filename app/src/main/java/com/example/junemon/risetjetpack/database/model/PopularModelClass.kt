package com.example.junemon.risetjetpack.database.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.databinding.BindingAdapter
import android.os.Parcelable
import android.widget.ImageView
import com.squareup.picasso.Picasso
import kotlinx.android.parcel.Parcelize

class PopularModelClass(var page: Int?, var total_results: Int?, var total_pages: Int?, var results: List<Result>) {
    @Parcelize
    @Entity(tableName = "popular_movie_model")
    class Result(@PrimaryKey(autoGenerate = true) var id_popularMovie: Int?,
                 @ColumnInfo(name = "movie_vote_count") var vote_count: Int?,
                 @ColumnInfo(name = "movie_id") var id: Int?,
                 @ColumnInfo(name = "movie_video") var video: Boolean?,
                 @ColumnInfo(name = "movie_vote_average") var vote_average: Double?,
                 @ColumnInfo(name = "movie_title") var title: String?,
                 @ColumnInfo(name = "movie_popularity") var popularity: Double?,
                 @ColumnInfo(name = "movie_poster_path") var poster_path: String?,
                 @ColumnInfo(name = "movie_original_language") var original_language: String?,
                 @ColumnInfo(name = "movie_original_title") var original_title: String?,
                 @ColumnInfo(name = "movie_backdrop_path") var backdrop_path: String?,
                 @ColumnInfo(name = "movie_adult") var adult: Boolean?,
                 @ColumnInfo(name = "movie_overview") var overview: String?,
                 @ColumnInfo(name = "movie_release_date") var release_date: String?) : Parcelable {
        constructor() : this(null, null, null, null, null, null, null,
                null, null, null, null, null, null,
                null)

        companion object {
            @BindingAdapter("poster_path")
            @JvmStatic
            fun loadImage(target: ImageView, imageUrl: String?) {
                Picasso.get().load(imageUrl).into(target)
            }
        }

    }
}