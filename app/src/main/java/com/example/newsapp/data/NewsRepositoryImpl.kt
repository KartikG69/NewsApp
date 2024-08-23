package com.example.newsapp.data

import com.example.newsapp.data.response.NewsResponse
import com.example.newsapp.domain.Repository
import retrofit2.Response
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(private val api: NewsApi) : Repository {
    override suspend fun getNews(
        language: String,
        text: String?,
        country: String?
    ): Response<NewsResponse> {
        return api.getNews(country, language, text)
    }
}