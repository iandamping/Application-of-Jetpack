package com.example.junemon.risetjetpack.helper.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.junemon.risetjetpack.database.model.SimilarMovieModelClass

class SimilarViewModel : ViewModel() {
    private var popularData: MutableLiveData<List<SimilarMovieModelClass.Result>>? = MutableLiveData()

    fun setData(data: List<SimilarMovieModelClass.Result>) {
        popularData?.value = data
    }

    fun getData(): MutableLiveData<List<SimilarMovieModelClass.Result>>? = popularData
}