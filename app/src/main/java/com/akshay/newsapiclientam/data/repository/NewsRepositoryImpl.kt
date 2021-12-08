package com.akshay.newsapiclientam.data.repository

import com.akshay.newsapiclientam.data.model.ApiResponse
import com.akshay.newsapiclientam.data.model.Article
import com.akshay.newsapiclientam.data.repository.datasource.NewsLocalDataSource
import com.akshay.newsapiclientam.data.repository.datasource.NewsRemoteDataSource
import com.akshay.newsapiclientam.data.util.Resource
import com.akshay.newsapiclientam.domain.repositories.NewsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class NewsRepositoryImpl(private val newsRemoteDataSource: NewsRemoteDataSource
,private val newsLocalDataSource: NewsLocalDataSource):NewsRepository {
    override suspend fun getNewsHeadlines(country:String,page:Int): Resource<ApiResponse> {
        return responseToResource(newsRemoteDataSource.getTopHeadlines(country,page))
    }

    override suspend fun getSearchedNews(country:String,searchQuery: String,page: Int): Resource<ApiResponse> {
        return responseToResource(newsRemoteDataSource.getSearchedNews(country,searchQuery,page))
    }

    override suspend fun saveNews(article: Article) {
        newsLocalDataSource.saveArticleToDb(article)
    }

    override suspend fun deleteNews(article: Article) {
        newsLocalDataSource.deleteArticlesFromDB(article)
    }

    override suspend fun getSavedNews(): Flow<List<Article>> {
        return newsLocalDataSource.getSavedArticles()
    }

    private fun responseToResource(response: Response<ApiResponse>):Resource<ApiResponse> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }


        }

        return Resource.Error(response.message())
    }
}