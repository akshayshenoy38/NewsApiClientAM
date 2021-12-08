package com.akshay.newsapiclientam.domain.usecase

import com.akshay.newsapiclientam.data.model.Article
import com.akshay.newsapiclientam.domain.repositories.NewsRepository

class SaveNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(article: Article) =newsRepository.saveNews(article)
}