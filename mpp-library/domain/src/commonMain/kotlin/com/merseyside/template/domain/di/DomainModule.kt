package com.merseyside.template.domain.di

import com.merseyside.kmpMerseyLib.utils.ext.logMsg
import com.merseyside.template.domain.db.DatabaseHelper
import com.merseyside.template.domain.entity.News
import com.merseyside.template.domain.repository.NewsRepository
import com.merseyside.template.domain.useCases.GetNewsUseCaseImpl
import com.merseyside.template.feature.list.domain.useCases.GetListUseCase
import com.merseyside.template.newsApi.di.newsApiModule
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.Dispatchers
import kotlinx.serialization.json.Json
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val domainModule = module {

    loadKoinModules(
        listOf(
            useCaseModule,
            newsApiModule
        )
    )

    single {
        Json {
            encodeDefaults = false
            isLenient = true
            ignoreUnknownKeys = true
        }
    }

    single {
        DatabaseHelper(sqlDriver = get(), Dispatchers.Default)
    }

    single {
        HttpClient {
//            install(ExceptionFeature) {
//                exceptionFactory = HttpExceptionFactory(
//                    defaultParser = ErrorExceptionParser(get()),
//                    customParsers = mapOf(
//                        //HttpStatusCode.UnprocessableEntity.value to ValidationExceptionParser(json)
//                    )
//                )
//            }
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        logMsg(message)
                    }
                }
                level = LogLevel.HEADERS
            }
//            install(TokenFeature) {
//                tokenHeaderName = "Authorization"
//                tokenProvider = object : TokenFeature.TokenProvider {
//                    override fun getToken(): String? = "token"
//                }
//            }

            defaultRequest {
                accept(ContentType.Application.Json)
                url {
                    protocol = URLProtocol.HTTPS
                    host = "newsapi.org/v2"
                    parameters.apply {
                        append("q", "android")
                        append("from", "2019-04-00")
                        append("sortBy", "publishedAt")
                        append("apiKey", "26eddb253e7840f988aec61f2ece2907")
                    }
                }
            }

            // disable standard BadResponseStatus - exceptionfactory do it for us
            expectSuccess = false
        }
    }

    single {
        NewsRepository(get())
    }
}