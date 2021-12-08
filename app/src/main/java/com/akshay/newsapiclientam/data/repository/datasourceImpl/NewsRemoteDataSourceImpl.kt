package com.akshay.newsapiclientam.data.repository.datasourceImpl

import com.akshay.newsapiclientam.data.api.NewsApiService
import com.akshay.newsapiclientam.data.model.ApiResponse
import com.akshay.newsapiclientam.data.repository.datasource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsApiService: NewsApiService
):NewsRemoteDataSource {
    override suspend fun getTopHeadlines(country:String,page:Int): Response<ApiResponse> {
        return newsApiService.getTopHeadlines(country,page)
    }

    override suspend fun getSearchedNews(
        country: String,
        searchQuery: String,
        page: Int
    ): Response<ApiResponse> {
        return newsApiService.getSearchedTopHeadlines(country,searchQuery,page)
    }
}