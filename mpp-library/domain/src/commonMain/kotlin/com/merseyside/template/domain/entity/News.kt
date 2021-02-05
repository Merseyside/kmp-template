package com.merseyside.template.domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class News(
    val author: String?,
    val title: String,
    val description: String,
    val url: String,
    val imageUrl: String?
)