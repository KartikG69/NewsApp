package com.example.newsapp.domain

import com.example.newsapp.data.response.NewsResponse
import retrofit2.Response

interface Repository {
    suspend fun getNews(
        language: String,
        text: String?,
        country: String?
    ): Response<NewsResponse>
}