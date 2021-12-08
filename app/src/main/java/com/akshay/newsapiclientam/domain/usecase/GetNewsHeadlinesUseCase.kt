package com.akshay.newsapiclientam.domain.usecase

import com.akshay.newsapiclientam.data.model.ApiResponse
import com.akshay.newsapiclientam.data.util.Resource
import com.akshay.newsapiclientam.domain.repositories.NewsRepository

class GetNewsHeadlinesUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(country:String,page:Int): Resource<ApiResponse> {
        return newsRepository.getNewsHeadlines(country,page)
    }
}