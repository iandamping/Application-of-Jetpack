package com.example.junemon.risetjetpack.helper.repo

import android.util.Log
import com.example.junemon.risetjetpack.MainApplication
import com.example.junemon.risetjetpack.database.model.PopularModelClass
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class PopularRepository {
    private var composite: CompositeDisposable = CompositeDisposable()

    fun setDetailMovie(page: Int?) {
        composite.add(MainApplication.getMovieData.getPopularMovieData("9986464dc7ff8e83569e65a98dc7b3b6", page!!)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe { savingData(it.results) })
    }

    private fun savingData(allData: List<PopularModelClass.Result>) {
        composite.add(Observable.fromCallable {
            Runnable {
                MainApplication.movieDatabaseAcces?.popularMovieDao()?.insertPopularMovie(allData)
            }.run()
        }.subscribeOn(Schedulers.io()).subscribe { Log.d("Popular Repo", "Succed") })
    }

    fun onStop() {
        if (composite != null && composite.isDisposed) {
            composite.dispose()
        }
    }
}