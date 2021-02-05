package com.merseyside.template.mppLibrary

import com.merseyside.template.domain.di.domainModule
import com.merseyside.template.domain.di.useCaseModule
import com.merseyside.template.domain.useCases.GetNewsUseCaseImpl
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(vararg appModules: Module, appDeclaration: KoinAppDeclaration = {}): KoinApplication {
    val koinApplication = startKoin {
        appDeclaration()
        modules(
            *appModules,
            platformModule,
            domainModule
        )
    }

    val koin = koinApplication.koin
//    val doOnStartup = koin.get<() -> Unit>() // doOnStartup is a lambda which is implemented in Swift on iOS side
//    doOnStartup.invoke()

    return koinApplication
}