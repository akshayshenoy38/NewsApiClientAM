package com.akshay.newsapiclientam.data.api

import com.akshay.newsapiclientam.BuildConfig
import com.akshay.newsapiclientam.data.model.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsApiService {

    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country:String,
        @Query("page") page:Int,
        @Query("apiKey")
        apiKey:String = BuildConfig.API_KEY
    ): Response<ApiResponse>


    @GET("v2/top-headlines")
    suspend fun getSearchedTopHeadlines(
        @Query("country")
        country:String,
        @Query("q")
        searchQuery:String,
        @Query("page")
        page:Int,
        @Query("apiKey")
        apiKey:String = BuildConfig.API_KEY
    ): Response<ApiResponse>
}