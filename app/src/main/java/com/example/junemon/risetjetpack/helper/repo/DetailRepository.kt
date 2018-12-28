package com.example.junemon.risetjetpack.helper.repo

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.support.v4.app.Fragment
import com.example.junemon.risetjetpack.MainApplication
import com.example.junemon.risetjetpack.R
import com.example.junemon.risetjetpack.helper.viewmodel.DetailViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class DetailRepository(var ctx: Context?, var target: Fragment) {
    private var composite: CompositeDisposable = CompositeDisposable()
    private var vm: DetailViewModel? = null

    init {
        vm = ViewModelProviders.of(target).get(DetailViewModel::class.java)
    }

    fun setDetailMovie(movieID: Int?) {
        composite.add(MainApplication.getMovieData.getDetailMovieData(movieID, ctx?.getString(R.string.api_key)!!).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe { vm?.setData(it) })
    }

    fun onStop() {
        if (composite != null && composite.isDisposed) {
            composite.dispose()
        }
    }
}