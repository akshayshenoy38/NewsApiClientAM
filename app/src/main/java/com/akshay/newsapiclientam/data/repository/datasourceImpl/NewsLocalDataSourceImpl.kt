package com.akshay.newsapiclientam.data.repository.datasourceImpl

import com.akshay.newsapiclientam.data.db.ArticleDao
import com.akshay.newsapiclientam.data.model.Article
import com.akshay.newsapiclientam.data.repository.datasource.NewsLocalDataSource
import kotlinx.coroutines.flow.Flow

class NewsLocalDataSourceImpl(
    private val articleDao: ArticleDao
):NewsLocalDataSource {
    override suspend fun saveArticleToDb(article: Article) {
        articleDao.insert(article)
    }

    override fun getSavedArticles(): Flow<List<Article>> {
        return articleDao.getAllArticles()
    }

    override suspend fun deleteArticlesFromDB(article: Article) {
        articleDao.deleteArticle(article)
    }
}