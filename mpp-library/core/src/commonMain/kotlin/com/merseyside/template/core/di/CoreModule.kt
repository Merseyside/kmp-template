package com.merseyside.template.core.di

import com.merseyside.merseyLib.utils.core.ext.logMsg
import com.merseyside.template.core.db.DatabaseHelper
import com.merseyside.template.newsApi.di.newsApiModule
import io.ktor.client.*
import io.ktor.client.features.logging.*
import kotlinx.coroutines.Dispatchers
import kotlinx.serialization.json.Json
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val coreModule = module {

    loadKoinModules(
        listOf(
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

            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        logMsg(message)
                    }
                }
                level = LogLevel.HEADERS
            }

            expectSuccess = false
        }
    }
}