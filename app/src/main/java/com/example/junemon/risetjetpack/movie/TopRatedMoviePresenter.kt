package com.example.junemon.risetjetpack.movie

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import androidx.navigation.Navigation
import com.example.junemon.risetjetpack.base.BaseFragmentPresenter
import com.example.junemon.risetjetpack.database.model.PopularModelClass
import com.example.junemon.risetjetpack.database.model.TopRatedModelClass
import com.example.junemon.risetjetpack.database.model.UpcomingModelClass
import com.example.junemon.risetjetpack.databinding.FragmentTopRatedBinding
import com.example.junemon.risetjetpack.helper.viewmodel.PopularViewModel
import com.example.junemon.risetjetpack.helper.viewmodel.TopRatedViewModel
import com.example.junemon.risetjetpack.helper.viewmodel.UpComingViewModel
import com.example.junemon.risetjetpack.movie.adapter.popularadapter.PopularMovieClickListener
import com.example.junemon.risetjetpack.movie.adapter.popularadapter.PopularPagingMovieAdapter
import com.example.junemon.risetjetpack.movie.adapter.topratedadapter.TopRatedMovieClickListener
import com.example.junemon.risetjetpack.movie.adapter.topratedadapter.TopratedPagingMovieAdapter
import com.example.junemon.risetjetpack.movie.adapter.upcomingadapter.UpComingMovieClickListener
import com.example.junemon.risetjetpack.movie.adapter.upcomingadapter.UpComingPagingMovieAdapter

class TopRatedMoviePresenter(var mView: TopRatedMovieView, var target: Fragment, var binding: FragmentTopRatedBinding) : BaseFragmentPresenter {
    private var ctx: Context? = null
    private var popularVm: PopularViewModel? = null
    private var topratedVm: TopRatedViewModel? = null
    private var upcomingVm: UpComingViewModel? = null

    override fun onAttach(context: Context?) {
        this.ctx = context
        popularVm = ViewModelProviders.of(target).get(PopularViewModel::class.java)
        topratedVm = ViewModelProviders.of(target).get(TopRatedViewModel::class.java)
        upcomingVm = ViewModelProviders.of(target).get(UpComingViewModel::class.java)
    }

    override fun onCreateView(view: View) {
        mView.initView(view)
    }


    fun setPopularMovieData(adapter: PopularPagingMovieAdapter) {
        binding.rvPopularMovie.layoutManager = LinearLayoutManager(ctx, LinearLayoutManager.HORIZONTAL, false)
        binding.rvPopularMovie.adapter = adapter
        popularVm?.getAllMovies()?.observe(target, Observer {
            adapter.submitList(it)
            adapter.notifyDataSetChanged()
        })
        adapter.setOnItemClickListener(object : PopularMovieClickListener {
            override fun onClick(view: View, data: PopularModelClass.Result) {
                Navigation.findNavController(view).navigate(TopRatedMovieFragmentDirections.actionTopRatedFragmentToDetailPopularMovieFragment(data.id!!))
            }

        })
    }

    fun setTopRatedMovie(adapter: TopratedPagingMovieAdapter) {
        binding.rvTopRatedMovie.layoutManager = LinearLayoutManager(ctx, LinearLayoutManager.HORIZONTAL, false)
        binding.rvTopRatedMovie.adapter = adapter
        topratedVm?.getAllMovies()?.observe(target, Observer {
            adapter.submitList(it)
            adapter.notifyDataSetChanged()
        })
        adapter.setOnItemClickListener(object : TopRatedMovieClickListener {
            override fun onClick(view: View, data: TopRatedModelClass.Result) {
                Navigation.findNavController(view).navigate(TopRatedMovieFragmentDirections.actionTopRatedFragmentToDetailPopularMovieFragment(data.id!!))
            }

        })
    }

    fun setUpcomingMovie(adapter: UpComingPagingMovieAdapter) {
        binding.rvUpcomingMovie.layoutManager = LinearLayoutManager(ctx, LinearLayoutManager.HORIZONTAL, false)
        binding.rvUpcomingMovie.adapter = adapter
        upcomingVm?.getAllMovies()?.observe(target, Observer {
            adapter.submitList(it)
            adapter.notifyDataSetChanged()
        })
        adapter.setOnItemClickListener(object : UpComingMovieClickListener {
            override fun onClick(view: View, data: UpcomingModelClass.Result) {
                Navigation.findNavController(view).navigate(TopRatedMovieFragmentDirections.actionTopRatedFragmentToDetailPopularMovieFragment(data.id!!))
            }
        })
    }
}