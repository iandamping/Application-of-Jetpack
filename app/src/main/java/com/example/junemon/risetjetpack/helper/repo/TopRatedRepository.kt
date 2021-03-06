package com.example.junemon.risetjetpack.helper.repo

import android.util.Log
import com.example.junemon.risetjetpack.MainApplication
import com.example.junemon.risetjetpack.database.model.TopRatedModelClass
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class TopRatedRepository {
    private var composite: CompositeDisposable = CompositeDisposable()

    fun setTopRatedMovie(page: Int?) {
        composite.add(MainApplication.getMovieData.getTopRatedMovieData("9986464dc7ff8e83569e65a98dc7b3b6", page!!)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe { savingData(it.results) })
    }

    private fun savingData(allData: List<TopRatedModelClass.Result>) {
        composite.add(Observable.fromCallable {
            Runnable {
                MainApplication.movieDatabaseAcces?.topRatedMovieDao()?.insertTopRatedMovie(allData)
            }.run()
        }.subscribeOn(Schedulers.io()).subscribe {
            Log.d("Toprated Repo", "Succed")
        })
    }

    fun onStop() {
        if (composite != null && composite.isDisposed) {
            composite.dispose()
        }
    }
}