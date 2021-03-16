package com.merseyside.template.fragments.main.di

import com.merseyside.kmpMerseyLib.arch.presentation.di.savedStateViewModel
import com.merseyside.template.fragments.main.view.NewsFragment
import com.merseyside.template.mppLibrary.NewsEventsDispatcher
import com.merseyside.template.mppLibrary.NewsViewModel
import dev.icerock.moko.mvvm.dispatcher.eventsDispatcherOnMain
import org.koin.core.qualifier.named
import org.koin.dsl.module

val mainModule = module {
    scope(qualifier = named<NewsFragment>()) {
       scoped<NewsEventsDispatcher> { eventsDispatcherOnMain() }

        savedStateViewModel {
            NewsViewModel(
                eventsDispatcher = get(),
                getListUseCase = get()
            )
        }
    }
}