package com.merseyside.template.domain.mapper

import com.merseyside.template.domain.entity.News
import com.merseyside.template.newsApi.entity.point.ArticlePoint

class NewsMapper {

    fun map(list: List<ArticlePoint>): List<News> {
        return list.map {
            News(
                author = it.author,
                title = it.title,
                description = it.description,
                url = it.url,
                imageUrl = it.imageUrl
            )
        }
    }
}