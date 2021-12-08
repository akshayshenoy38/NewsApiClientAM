package com.akshay.newsapiclientam.domain.usecase

import com.akshay.newsapiclientam.data.model.Article
import com.akshay.newsapiclientam.domain.repositories.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetSavedNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(): Flow<List<Article>> {

        return newsRepository.getSavedNews()

    }
}