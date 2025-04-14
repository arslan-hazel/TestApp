package com.example.hazelnews.data.remote.datasource

import com.example.hazelnews.data.remote.api.NewsApi
import com.example.hazelnews.domain.models.NewsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val newsApi: NewsApi
) : RemoteDataSource {

    override suspend fun getHeadlines(countryCode: String, page: Int): Response<NewsResponse> {
        return withContext(Dispatchers.IO) {
            newsApi.getNewsHeadlines(countryCode, page)

        }

    }

    override suspend fun searchNews(query: String, page: Int): Response<NewsResponse> {
        return withContext(Dispatchers.IO) {
            newsApi.searchForNews(query, page)
        }
    }
}
