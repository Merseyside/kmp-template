package com.merseyside.template.domain.repository

import com.merseyside.template.domain.entity.News
import com.merseyside.template.domain.mapper.NewsMapper
import com.merseyside.template.newsApi.NewsApi

class NewsRepository(
    private val api: NewsApi
) {

    private val mapper = NewsMapper()

    suspend fun getNews(): List<News> = mapper.map(api.getNews().articles)
}