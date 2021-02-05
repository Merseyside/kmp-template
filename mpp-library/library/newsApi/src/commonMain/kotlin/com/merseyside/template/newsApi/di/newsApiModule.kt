package com.merseyside.template.newsApi.di

import com.merseyside.template.newsApi.NewsApi
import org.koin.dsl.module

val newsApiModule = module {

    single {
        NewsApi(client = get(), json = get())
    }
}