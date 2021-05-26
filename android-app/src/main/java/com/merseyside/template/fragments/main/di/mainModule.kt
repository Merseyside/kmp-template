package com.merseyside.template.fragments.main.di

import com.merseyside.template.fragments.main.view.NewsFragment
import com.merseyside.template.mppLibrary.NewsEventsDispatcher
import com.merseyside.template.mppLibrary.NewsViewModel
import dev.icerock.moko.mvvm.dispatcher.eventsDispatcherOnMain
import org.koin.core.qualifier.named
import org.koin.dsl.module
import com.merseyside.kmpMerseyLib.arch.presentation.di.stateViewModel

val mainModule = module {
    scope(qualifier = named<NewsFragment>()) {
       scoped<NewsEventsDispatcher> { eventsDispatcherOnMain() }

        stateViewModel {
            NewsViewModel(
                eventsDispatcher = get(),
                getListUseCase = get()
            )
        }
    }
}