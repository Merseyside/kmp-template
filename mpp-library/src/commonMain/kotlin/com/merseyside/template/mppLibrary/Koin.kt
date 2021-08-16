package com.merseyside.template.mppLibrary

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import com.merseyside.template.core.di.coreModule
import com.merseyside.template.domain.di.domainModule

fun initKoin(vararg appModules: Module, appDeclaration: KoinAppDeclaration = {}): KoinApplication {
    val koinApplication = startKoin {
        appDeclaration()
        modules(
            *appModules,
            platformModule,
            coreModule,
            domainModule
        )
    }

//    val koin = koinApplication.koin
//    val doOnStartup = koin.get<() -> Unit>() // doOnStartup is a lambda which is implemented in Swift on iOS side
//    doOnStartup.invoke()

    return koinApplication
}