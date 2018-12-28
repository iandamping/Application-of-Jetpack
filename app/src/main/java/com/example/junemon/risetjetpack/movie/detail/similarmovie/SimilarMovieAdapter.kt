package com.example.junemon.risetjetpack.movie.detail.similarmovie

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.junemon.risetjetpack.database.model.SimilarMovieModelClass
import com.example.junemon.risetjetpack.databinding.ItemSimilarMovieBinding

class SimilarMovieAdapter(var ctx: Context?, var listData: List<SimilarMovieModelClass.Result>) : RecyclerView.Adapter<SimilarMovieAdapter.SimilarMovieViewHolder>() {
    lateinit var listener: SimilarMovieClickListener
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): SimilarMovieViewHolder {
        val inflater = LayoutInflater.from(ctx)
        val binding = ItemSimilarMovieBinding.inflate(inflater, p0, false)
        return SimilarMovieViewHolder(binding)
    }

    override fun getItemCount(): Int = listData.size

    override fun onBindViewHolder(p0: SimilarMovieViewHolder, p1: Int) {
        val data = listData.get(p1)
        p0.binding.similarData = data
        p0.binding.ivSimilarMovie.setOnClickListener {
            listener.onClick(it, data)
        }

    }

    fun setOnItemClickListener(listener: SimilarMovieClickListener) {
        this.listener = listener
    }

    class SimilarMovieViewHolder(var binding: ItemSimilarMovieBinding) : RecyclerView.ViewHolder(binding.root)
}