package com.example.junemon.risetjetpack.base

import android.content.Context

interface BasePresenter {
    fun getContext(): Context?
    fun onCreate(context: Context)
    fun onPause()
    fun onStop()
}