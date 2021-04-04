package com.sride.newsfeedapp.database.repository

import com.sride.newsfeedapp.database.Result
import com.sride.newsfeedapp.api.BaseDataSource
import com.sride.newsfeedapp.api.NewsListResponse
import com.sride.newsfeedapp.api.NewsService
import com.sride.newsfeedapp.common.KEYWORD
import javax.inject.Inject

class NewsRemoteDataSource @Inject constructor(private val service: NewsService) : BaseDataSource() {

    suspend fun fetchNewsList(apiKey : String, page : Int, pageSize : Int ) : Result<NewsListResponse> {
        return getResult { service.getTopNewsList(apiKey, page,pageSize, KEYWORD) }
    }
}
