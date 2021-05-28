package com.merseyside.template.domain.repository

import com.merseyside.template.domain.entity.News

interface NewsRepository {

    suspend fun getNews(): List<News>
}