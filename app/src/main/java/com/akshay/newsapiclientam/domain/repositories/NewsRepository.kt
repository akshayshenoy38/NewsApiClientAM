package com.akshay.newsapiclientam.domain.repositories


import com.akshay.newsapiclientam.data.model.ApiResponse
import com.akshay.newsapiclientam.data.model.Article
import com.akshay.newsapiclientam.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    suspend fun getNewsHeadlines(country:String,page:Int):Resource<ApiResponse>
    suspend fun getSearchedNews(country:String,searchQuery:String,page:Int) : Resource<ApiResponse>

    suspend fun saveNews(article: Article)
    suspend fun deleteNews(article: Article)
    suspend fun getSavedNews():Flow<List<Article>>

}