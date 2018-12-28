package com.example.junemon.risetjetpack.movie.adapter.upcomingadapter

import android.arch.paging.PagedListAdapter
import android.content.Context
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.junemon.risetjetpack.database.model.UpcomingModelClass
import com.example.junemon.risetjetpack.databinding.ItemUpcomingMovieBinding

class UpComingPagingMovieAdapter(var ctx: Context?) : PagedListAdapter<UpcomingModelClass.Result, UpComingPagingMovieAdapter.upComingMovieViewHolder>(diffCallbacks) {
    lateinit var listener: UpComingMovieClickListener
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): upComingMovieViewHolder {
        val inflater = LayoutInflater.from(ctx)
        val binding = ItemUpcomingMovieBinding.inflate(inflater, p0, false)
        return upComingMovieViewHolder(binding)
    }

    override fun onBindViewHolder(p0: upComingMovieViewHolder, p1: Int) {
        val data = getItem(p1)
        if (data != null) {
            p0.binding.upComing = data
            p0.binding.llMoviesProperties.setOnClickListener {
                listener.onClick(it, data)
            }
        }
    }

    fun setOnItemClickListener(listener: UpComingMovieClickListener) {
        this.listener = listener
    }

    class upComingMovieViewHolder(var binding: ItemUpcomingMovieBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    companion object {
        private val diffCallbacks = object : DiffUtil.ItemCallback<UpcomingModelClass.Result>() {
            override fun areItemsTheSame(oldItem: UpcomingModelClass.Result, newItem: UpcomingModelClass.Result): Boolean =
                    oldItem.poster_path == newItem.poster_path

            override fun areContentsTheSame(oldItem: UpcomingModelClass.Result, newItem: UpcomingModelClass.Result): Boolean =
                    oldItem == newItem
        }
    }
}