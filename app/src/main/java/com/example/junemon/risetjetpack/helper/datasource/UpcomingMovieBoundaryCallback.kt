package com.example.junemon.risetjetpack.helper.datasource

import android.arch.paging.PagedList
import com.example.junemon.risetjetpack.database.model.UpcomingModelClass
import com.example.junemon.risetjetpack.helper.repo.UpComingRepository

class UpcomingMovieBoundaryCallback : PagedList.BoundaryCallback<UpcomingModelClass.Result>() {
    private var upcomingRepo: UpComingRepository = UpComingRepository()
    private var firstPage = 1

    override fun onZeroItemsLoaded() {
        super.onZeroItemsLoaded()
        insertAndSaveMovie(firstPage)
    }

    override fun onItemAtEndLoaded(itemAtEnd: UpcomingModelClass.Result) {
        super.onItemAtEndLoaded(itemAtEnd)
        insertAndSaveMovie(firstPage)
    }

    private fun insertAndSaveMovie(page: Int) {
        upcomingRepo.setUpComingMovie(page)
        firstPage++
    }
}