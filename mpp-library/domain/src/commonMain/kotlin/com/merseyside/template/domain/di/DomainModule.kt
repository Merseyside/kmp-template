package com.merseyside.template.domain.di

import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val domainModule = module {
    loadKoinModules(useCaseModule)
}