package com.merseyside.template.newsApi.entity.point

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticlePoint(
    val author: String?,
    val title: String?,
    val description: String,
    val url: String,

    @SerialName("urlToImage")
    val imageUrl: String?
)