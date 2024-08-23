package com.example.newsapp.di

import com.example.newsapp.data.NewsApi
import com.example.newsapp.data.NewsRepositoryImpl
import com.example.newsapp.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideNewsRepository(api: NewsApi): Repository {
        return NewsRepositoryImpl(api)
    }

}