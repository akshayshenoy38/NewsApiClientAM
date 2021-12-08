package com.akshay.newsapiclientam.presentation.di

import com.akshay.newsapiclientam.data.api.NewsApiService
import com.akshay.newsapiclientam.data.repository.datasource.NewsRemoteDataSource
import com.akshay.newsapiclientam.data.repository.datasourceImpl.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideNewsRemoteDataSource(newsApiService: NewsApiService):NewsRemoteDataSource {
        return NewsRemoteDataSourceImpl(newsApiService)
    }

}