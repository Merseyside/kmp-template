package com.merseyside.template.domain.di

import com.merseyside.template.domain.useCases.GetNewsUseCase
import org.koin.dsl.module

val useCaseModule = module {

    single {
        GetNewsUseCase(get())
    }
}