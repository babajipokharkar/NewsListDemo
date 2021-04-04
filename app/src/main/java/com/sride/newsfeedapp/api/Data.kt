package com.sride.newsfeedapp.api

import androidx.lifecycle.LiveData
import androidx.paging.PagedList

data class Data<T>(
        val pagedList: LiveData<PagedList<T>>,
        val networkState: LiveData<NetworkState>)