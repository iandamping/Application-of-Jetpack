package com.example.junemon.risetjetpack.helper.datasource

import android.arch.paging.PagedList
import com.example.junemon.risetjetpack.database.model.PopularModelClass
import com.example.junemon.risetjetpack.helper.repo.PopularRepository

class PopularMovieBoundaryCallback : PagedList.BoundaryCallback<PopularModelClass.Result>() {
    private var popularRepo: PopularRepository = PopularRepository()
    private var firstPage = 1

    override fun onZeroItemsLoaded() {
        super.onZeroItemsLoaded()
        insertAndSaveMovie(firstPage)
    }

    override fun onItemAtEndLoaded(itemAtEnd: PopularModelClass.Result) {
        super.onItemAtEndLoaded(itemAtEnd)
        insertAndSaveMovie(firstPage)
    }

    private fun insertAndSaveMovie(page: Int) {
        popularRepo.setDetailMovie(page)
        firstPage++
    }
}