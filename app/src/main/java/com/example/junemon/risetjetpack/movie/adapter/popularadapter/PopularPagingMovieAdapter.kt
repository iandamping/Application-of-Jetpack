package com.example.junemon.risetjetpack.movie.adapter.popularadapter

import android.arch.paging.PagedListAdapter
import android.content.Context
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.junemon.risetjetpack.database.model.PopularModelClass
import com.example.junemon.risetjetpack.databinding.ItemPopularMovieBinding

class PopularPagingMovieAdapter(var ctx: Context?) : PagedListAdapter<PopularModelClass.Result, PopularPagingMovieAdapter.NajibMovieViewHolder>(diffCallbacks) {
    lateinit var listener: PopularMovieClickListener
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): NajibMovieViewHolder {
        val inflater = LayoutInflater.from(ctx)
        val binding = ItemPopularMovieBinding.inflate(inflater, p0, false)
        return PopularPagingMovieAdapter.NajibMovieViewHolder(binding)
    }

    override fun onBindViewHolder(p0: NajibMovieViewHolder, p1: Int) {
        val data = getItem(p1)
        if (data != null) {
            p0.binding.movieDatas = data
            p0.binding.llMoviesProperties.setOnClickListener {
                listener.onClick(it, data)
            }
        }
    }

    fun setOnItemClickListener(listener: PopularMovieClickListener) {
        this.listener = listener
    }

    class NajibMovieViewHolder(var binding: ItemPopularMovieBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    companion object {
        private val diffCallbacks = object : DiffUtil.ItemCallback<PopularModelClass.Result>() {
            override fun areItemsTheSame(oldItem: PopularModelClass.Result, newItem: PopularModelClass.Result): Boolean =
                    oldItem.poster_path == newItem.poster_path

            override fun areContentsTheSame(oldItem: PopularModelClass.Result, newItem: PopularModelClass.Result): Boolean =
                    oldItem == newItem
        }
    }
}