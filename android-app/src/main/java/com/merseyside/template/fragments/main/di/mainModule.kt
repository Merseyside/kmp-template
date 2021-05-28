package com.merseyside.template.fragments.main.di

import com.merseyside.template.fragments.main.view.NewsFragment
import com.merseyside.template.mppLibrary.NewsEventsDispatcher
import dev.icerock.moko.mvvm.dispatcher.eventsDispatcherOnMain
import org.koin.core.qualifier.named
import org.koin.dsl.module
import com.merseyside.kmpMerseyLib.arch.presentation.di.stateViewModel
import com.merseyside.template.feature.news.presentation.NewsViewModel

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