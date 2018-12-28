package com.example.junemon.risetjetpack.helper.datasource

import android.arch.paging.PagedList
import com.example.junemon.risetjetpack.database.model.TopRatedModelClass
import com.example.junemon.risetjetpack.helper.repo.TopRatedRepository

class TopratedMovieBoundaryCallback : PagedList.BoundaryCallback<TopRatedModelClass.Result>() {
    private var topRatedRepo: TopRatedRepository = TopRatedRepository()
    private var firstPage = 1

    override fun onZeroItemsLoaded() {
        super.onZeroItemsLoaded()
        insertAndSaveMovie(firstPage)
    }

    override fun onItemAtEndLoaded(itemAtEnd: TopRatedModelClass.Result) {
        super.onItemAtEndLoaded(itemAtEnd)
        insertAndSaveMovie(firstPage)
    }

    private fun insertAndSaveMovie(page: Int) {
        topRatedRepo.setTopRatedMovie(page)
        firstPage++
    }
}