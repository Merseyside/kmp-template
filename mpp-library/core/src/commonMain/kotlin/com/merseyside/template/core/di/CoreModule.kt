package com.merseyside.template.core.di

import io.ktor.client.*
import io.ktor.client.features.logging.*
import kotlinx.serialization.json.Json
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import com.merseyside.merseyLib.utils.core.Logger as AppLogger

private val httpClientConfig: HttpClientConfig<*>.() -> Unit = {
    install(Logging) {
        logger = object : Logger {
            override fun log(message: String) {
                AppLogger.log(tag = "HTTP", message)
            }
        }
        level = LogLevel.ALL
    }

    // disable standard BadResponseStatus - exceptionfactory do it for us
    expectSuccess = false
}

private val featureModule = module {
    loadKoinModules(
        listOf(

        )
    )
}

private val networkModule = module {

    single {
        httpClientConfig
    }

//    single<() -> HttpClient> {
//        get<AuthManager>().httpClient
//    }

    single {
        Json {
            encodeDefaults = false
            isLenient = true
            ignoreUnknownKeys = true
        }
    }
}

private val reposModule = module {

}

val coreModule = module {

    loadKoinModules(
        listOf(
            networkModule,
            featureModule,
            reposModule,
            //dbModule
        )
    )
}