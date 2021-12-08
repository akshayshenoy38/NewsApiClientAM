package com.akshay.newsapiclientam.data.repository.datasource

import com.akshay.newsapiclientam.data.model.ApiResponse
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getTopHeadlines(country:String,page:Int):Response<ApiResponse>
    suspend fun getSearchedNews(country:String,searchQuery:String,page:Int):Response<ApiResponse>
}