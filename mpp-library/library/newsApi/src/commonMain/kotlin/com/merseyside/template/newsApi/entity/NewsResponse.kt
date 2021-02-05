package com.merseyside.template.newsApi.entity

import com.merseyside.template.newsApi.entity.point.ArticlePoint
import kotlinx.serialization.Serializable

@Serializable
data class NewsResponse(
    val status: String,
    val articles: List<ArticlePoint>
)