package com.example.junemon.risetjetpack.movie


import android.arch.paging.PagedList
import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.junemon.risetjetpack.R
import com.example.junemon.risetjetpack.database.model.PopularModelClass
import com.example.junemon.risetjetpack.database.model.TopRatedModelClass
import com.example.junemon.risetjetpack.database.model.UpcomingModelClass
import com.example.junemon.risetjetpack.databinding.FragmentTopRatedBinding
import com.example.junemon.risetjetpack.movie.adapter.popularadapter.PopularPagingMovieAdapter
import com.example.junemon.risetjetpack.movie.adapter.topratedadapter.TopratedPagingMovieAdapter
import com.example.junemon.risetjetpack.movie.adapter.upcomingadapter.UpComingPagingMovieAdapter


class TopRatedMovieFragment : Fragment(), TopRatedMovieView {
    private var ctx: Context? = null
    private lateinit var presenter: TopRatedMoviePresenter
    private lateinit var topRatedMovieAdapter: TopratedPagingMovieAdapter
    private lateinit var popularMovieAdapter: PopularPagingMovieAdapter
    private lateinit var upcomingMovieAdapter: UpComingPagingMovieAdapter
    private lateinit var binding: FragmentTopRatedBinding
//    private lateinit var navigation: Navigation

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        this.ctx = context
        popularMovieAdapter = PopularPagingMovieAdapter(ctx)
        topRatedMovieAdapter = TopratedPagingMovieAdapter(ctx)
        upcomingMovieAdapter = UpComingPagingMovieAdapter(ctx)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        presenter.setTopRatedMovie(topRatedMovieAdapter)
        presenter.setPopularMovieData(popularMovieAdapter)
        presenter.setUpcomingMovie(upcomingMovieAdapter)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_top_rated, container, false)
        presenter = TopRatedMoviePresenter(this, this, binding)
        presenter.onAttach(ctx)
//        binding.btnSwitch.setOnClickListener { view -> Navigation.findNavController(view).navigate(TopRatedMovieFragmentDirections.actionTopRatedFragmentToMovieFragment()) }
        return binding.root
    }


    override fun initView(view: View) {
    }

    override fun getAllTopRatedMovieData(allData: List<TopRatedModelClass.Result>?) {
    }

    override fun getAllPopularMovieData(allData: PagedList<PopularModelClass.Result>?) {
    }

    override fun getAllUpcomingMovieData(allData: List<UpcomingModelClass.Result>?) {
    }

}
