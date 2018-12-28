package com.example.junemon.risetjetpack.database.model

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso

data class DetailMovieModelClass(var adult: Boolean, var backdrop_path: String, var belongs_to_collection: BelongsToCollection,
                                 var budget: Int, var genres: List<Genre>, var id: Int, var imdb_id: String, var original_language: String,
                                 var original_title: String, var overview: String, var popularity: Double, var poster_path: String, var production_companies: List<ProductionCompany>,
                                 var production_countries: List<ProductionCountry>, var release_date: String, var revenue: String, var runtime: Int,
                                 var spoken_languages: List<SpokenLanguage>, var status: String, var tagline: String, var title: String, var video: Boolean,
                                 var vote_average: Double, var vote_count: Int) {
    companion object {
        @BindingAdapter("poster_path")
        @JvmStatic
        fun loadImage(target: ImageView, imageUrl: String?) {
            Picasso.get().load(imageUrl).into(target)

        }
    }


    class BelongsToCollection(var id: Int, var name: String, var posterPath: String, var backdropPath: String)
    class Genre(var id: Int, var name: String)
    class ProductionCompany(var id: Int, var logoPath: String, var name: String, var originCountry: String)
    class ProductionCountry(var iso31661: String, var name: String)
    class SpokenLanguage(var iso31661: String, var name: String)

}