package com.sride.newsfeedapp.ui.main.home

import androidx.lifecycle.ViewModel
import com.sride.newsfeedapp.api.Data
import com.sride.newsfeedapp.api.NewsListModel
import com.sride.newsfeedapp.database.repository.NewsRepository
import com.sride.newsfeedapp.dependancyinjection.CoroutineScopeIO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val repository: NewsRepository,
    @CoroutineScopeIO private val ioCoroutineScope: CoroutineScope
) : ViewModel() {
    private var newsList: Data<NewsListModel>? = null

    fun newsList(connectivityAvailable: Boolean): Data<NewsListModel>? {

        if (newsList == null) {
            newsList = repository.observePagedNews(connectivityAvailable, ioCoroutineScope)
        }
        return newsList
    }

    override fun onCleared() {
        super.onCleared()
        ioCoroutineScope.cancel()
    }
}
