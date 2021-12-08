package com.akshay.newsapiclientam.presentation.di

import android.app.Application
import com.akshay.newsapiclientam.domain.usecase.*
import com.akshay.newsapiclientam.presentation.viewmodel.NewsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    @Singleton
    @Provides
    fun provideNewsViewModelFactory(app:Application, getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase, getSearchedNewsUseCase: GetSearchedNewsUseCase
                                    , saveNewsUseCase: SaveNewsUseCase,
                                    getSavedNewsUseCase: GetSavedNewsUseCase,
                                    deleteSavedNewsUseCase: DeleteSavedNewsUseCase
    ) :NewsViewModelFactory{
        return NewsViewModelFactory(app, getNewsHeadlinesUseCase,getSearchedNewsUseCase,saveNewsUseCase
        , getSavedNewsUseCase,
        deleteSavedNewsUseCase)
    }
}