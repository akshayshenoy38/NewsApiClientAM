package com.akshay.newsapiclientam.domain.usecase

import com.akshay.newsapiclientam.data.model.ApiResponse
import com.akshay.newsapiclientam.data.util.Resource
import com.akshay.newsapiclientam.domain.repositories.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {


    suspend fun execute(country:String,searchQuery:String,page:Int): Resource<ApiResponse> {
        return newsRepository.getSearchedNews(country,searchQuery,page)
    }
}