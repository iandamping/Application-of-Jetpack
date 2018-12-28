package com.example.junemon.risetjetpack.base

import android.content.Context
import android.view.View

interface BaseFragmentPresenter {
    fun onAttach(context: Context?)
    fun onCreateView(view: View)
}