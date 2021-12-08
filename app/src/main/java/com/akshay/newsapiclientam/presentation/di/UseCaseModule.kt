package com.akshay.newsapiclientam.presentation.di

import com.akshay.newsapiclientam.domain.repositories.NewsRepository
import com.akshay.newsapiclientam.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideNewsHeadlineUseCase(newsRepository: NewsRepository):GetNewsHeadlinesUseCase {
        return GetNewsHeadlinesUseCase(newsRepository)
    }


    @Singleton
    @Provides
    fun provideSearchNewsUseCase(newsRepository: NewsRepository):GetSearchedNewsUseCase {
        return GetSearchedNewsUseCase(newsRepository)
    }

    @Singleton
    @Provides
    fun provideSaveNewsUseCase(newsRepository: NewsRepository):SaveNewsUseCase {
        return SaveNewsUseCase(newsRepository)
    }

    @Singleton
    @Provides
    fun provideGetSavedNewsUseCase(newsRepository: NewsRepository) :GetSavedNewsUseCase {
        return GetSavedNewsUseCase(newsRepository)
    }

    @Singleton
    @Provides
    fun deleteSavedNewsUseCase(newsRepository: NewsRepository) : DeleteSavedNewsUseCase {
        return DeleteSavedNewsUseCase(newsRepository)
    }



}