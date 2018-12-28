package com.example.junemon.risetjetpack.helper.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.junemon.risetjetpack.database.model.DetailMovieModelClass

class DetailViewModel : ViewModel() {
    private var detailData: MutableLiveData<DetailMovieModelClass>? = MutableLiveData()

    fun setData(data: DetailMovieModelClass) {
        detailData?.postValue(data)
    }

    fun getData(): MutableLiveData<DetailMovieModelClass>? = detailData
}