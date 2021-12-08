package com.akshay.newsapiclientam.domain.usecase

import com.akshay.newsapiclientam.data.model.Article
import com.akshay.newsapiclientam.domain.repositories.NewsRepository

class DeleteSavedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(article: Article)  =  newsRepository.deleteNews(article)
}