package com.example.junemon.risetjetpack.helper.repo

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.support.v4.app.Fragment
import com.example.junemon.risetjetpack.MainApplication
import com.example.junemon.risetjetpack.R
import com.example.junemon.risetjetpack.helper.viewmodel.SimilarViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class SimilarRepository(var ctx: Context?, var target: Fragment) {
    private var composite: CompositeDisposable
    private var vm: SimilarViewModel? = null

    init {
        composite = CompositeDisposable()
        vm = ViewModelProviders.of(target).get(SimilarViewModel::class.java)
    }

    fun setSimilarMovie(movieID: Int?) {
        composite.add(MainApplication.getMovieData.getSimilarMovieData(movieID, ctx?.getString(R.string.api_key)!!).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe { vm?.setData(it.results) })
    }

    fun onStop() {
        if (composite != null && composite.isDisposed) {
            composite.dispose()
        }
    }
}