package com.merseyside.template.newsApi

import com.merseyside.merseyLib.utils.core.ktor.KtorRouter
import com.merseyside.merseyLib.utils.core.ktor.get
import com.merseyside.template.newsApi.entity.NewsResponse
import io.ktor.client.*
import kotlinx.serialization.json.Json

class NewsApi(
    client: HttpClient,
    json: Json
) : KtorRouter(client, json) {

    suspend fun getNews(): NewsResponse {
        return get(path = "/everything")
    }
}