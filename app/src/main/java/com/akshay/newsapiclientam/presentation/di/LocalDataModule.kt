package com.akshay.newsapiclientam.presentation.di

import com.akshay.newsapiclientam.data.db.ArticleDao
import com.akshay.newsapiclientam.data.repository.datasource.NewsLocalDataSource
import com.akshay.newsapiclientam.data.repository.datasourceImpl.NewsLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {

    @Singleton
    @Provides
    fun provideLocalDataSource(articleDao: ArticleDao):NewsLocalDataSource {
        return NewsLocalDataSourceImpl(articleDao)
    }
}