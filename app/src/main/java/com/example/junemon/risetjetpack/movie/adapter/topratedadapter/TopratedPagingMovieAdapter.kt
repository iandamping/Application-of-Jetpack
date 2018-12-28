package com.example.junemon.risetjetpack.movie.adapter.topratedadapter

import android.arch.paging.PagedListAdapter
import android.content.Context
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.junemon.risetjetpack.database.model.TopRatedModelClass
import com.example.junemon.risetjetpack.databinding.ItemTopRatedMovieBinding

class TopratedPagingMovieAdapter(var ctx: Context?) : PagedListAdapter<TopRatedModelClass.Result, TopratedPagingMovieAdapter.TopRatedMovieViewHolder>(diffCallbacks) {
    lateinit var listener: TopRatedMovieClickListener
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): TopRatedMovieViewHolder {
        val inflater = LayoutInflater.from(ctx)
        val binding = ItemTopRatedMovieBinding.inflate(inflater, p0, false)
        return TopRatedMovieViewHolder(binding)
    }

    override fun onBindViewHolder(p0: TopRatedMovieViewHolder, p1: Int) {
        val data = getItem(p1)
        if (data != null) {
            p0.binding.topRated = data
            p0.binding.llMoviesProperties.setOnClickListener {
                listener.onClick(it, data)
            }
        }
    }

    fun setOnItemClickListener(listener: TopRatedMovieClickListener) {
        this.listener = listener
    }

    class TopRatedMovieViewHolder(var binding: ItemTopRatedMovieBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    companion object {
        private val diffCallbacks = object : DiffUtil.ItemCallback<TopRatedModelClass.Result>() {
            override fun areItemsTheSame(oldItem: TopRatedModelClass.Result, newItem: TopRatedModelClass.Result): Boolean =
                    oldItem.poster_path == newItem.poster_path

            override fun areContentsTheSame(oldItem: TopRatedModelClass.Result, newItem: TopRatedModelClass.Result): Boolean =
                    oldItem == newItem
        }
    }
}