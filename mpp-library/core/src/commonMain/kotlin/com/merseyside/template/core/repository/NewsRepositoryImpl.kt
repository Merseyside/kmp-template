package com.merseyside.template.core.repository

import com.merseyside.template.core.mapper.NewsMapper
import com.merseyside.template.domain.entity.News
import com.merseyside.template.domain.repository.NewsRepository
import com.merseyside.template.newsApi.NewsApi

class NewsRepositoryImpl(
    private val api: NewsApi
): NewsRepository {

    private val mapper = NewsMapper()

    override suspend fun getNews(): List<News> = mapper.map(api.getNews().articles)
}