package com.merseyside.template.core.mapper

import com.merseyside.template.domain.entity.News
import com.merseyside.template.newsApi.entity.point.ArticlePoint

class NewsMapper {

    fun map(list: List<ArticlePoint>): List<News> {
        return list.map {
            News(
                author = it.author,
                title = it.title ?: "No title",
                description = it.description,
                url = it.url,
                imageUrl = it.imageUrl
            )
        }
    }
}