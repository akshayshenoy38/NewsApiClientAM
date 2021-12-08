package com.akshay.newsapiclientam.presentation.di

import com.akshay.newsapiclientam.data.repository.NewsRepositoryImpl
import com.akshay.newsapiclientam.data.repository.datasource.NewsLocalDataSource
import com.akshay.newsapiclientam.data.repository.datasource.NewsRemoteDataSource
import com.akshay.newsapiclientam.domain.repositories.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideNewsRepository(newsRemoteDataSource: NewsRemoteDataSource
    ,newsLocalDataSource: NewsLocalDataSource):NewsRepository {
        return NewsRepositoryImpl(newsRemoteDataSource,newsLocalDataSource)
    }
}