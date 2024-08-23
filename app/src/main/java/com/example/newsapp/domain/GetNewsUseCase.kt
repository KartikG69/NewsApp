package com.example.newsapp.domain

import com.example.newsapp.data.response.NewsResponse
import org.intellij.lang.annotations.Language
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(
    private val newsRepository: Repository
) {
    suspend operator fun invoke(
        language: String,
        text: String?,
        country: String?
    ): NewsResponse {
        val response = newsRepository.getNews(language, text, country)
        if (response.body() == null) {
            if (response.code() == 404)
                throw Exception("No news found")
            else if (response.code() == 500)
                throw Exception("Server error")
            else if (response.code() == 401)
                throw Exception("Unauthorized")
            else if (response.code() == 400)
                throw Exception("Bad request")
            else
                throw Exception("No news found")
        }
        return newsRepository.getNews(language, text, country).body()!!
    }
}