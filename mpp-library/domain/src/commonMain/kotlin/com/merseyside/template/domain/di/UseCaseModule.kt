package com.merseyside.template.domain.di

import com.merseyside.template.domain.entity.News
import com.merseyside.template.domain.useCases.GetNewsUseCaseImpl
import com.merseyside.template.feature.list.domain.useCases.GetListUseCase
import org.koin.dsl.module

val useCaseModule = module {

    single<GetListUseCase<News>> {
        GetNewsUseCaseImpl(get())
    }
}