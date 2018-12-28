package com.example.junemon.risetjetpack.movie.detail

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.support.v4.app.Fragment
import android.view.View
import com.example.junemon.risetjetpack.base.BaseFragmentPresenter
import com.example.junemon.risetjetpack.helper.repo.DetailRepository
import com.example.junemon.risetjetpack.helper.repo.SimilarRepository
import com.example.junemon.risetjetpack.helper.viewmodel.DetailViewModel
import com.example.junemon.risetjetpack.helper.viewmodel.SimilarViewModel

class DetailPopularMoviePresenter(var mView: DetailPopularMovieView, var target: Fragment) : BaseFragmentPresenter {
    private var ctx: Context? = null
    private lateinit var detailRepo: DetailRepository
    private lateinit var similarRepo: SimilarRepository
    private var detailViewModel: DetailViewModel? = null
    private var similarViewModel: SimilarViewModel? = null

    override fun onAttach(context: Context?) {
        this.ctx = context
        detailRepo = DetailRepository(ctx, target)
        similarRepo = SimilarRepository(ctx, target)
        detailViewModel = ViewModelProviders.of(target).get(DetailViewModel::class.java)
        similarViewModel = ViewModelProviders.of(target).get(SimilarViewModel::class.java)
    }

    override fun onCreateView(view: View) {
        mView.initView(view)
    }

    fun getDataDetail(movieID: Int?) {
        detailRepo.setDetailMovie(movieID)
        detailViewModel?.getData()?.observe(target, Observer {
            mView.getDetailPopularMovie(it)
        })
    }

    fun getSimilarMovie(movieId: Int?) {
        similarRepo.setSimilarMovie(movieId)
        similarViewModel?.getData()?.observe(target, Observer {
            mView.getSimilarMovie(it)
        })

    }

    fun onStop() {
        detailRepo.onStop()
        similarRepo.onStop()
    }
}