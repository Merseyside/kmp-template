package com.merseyside.template.fragments.main.di

import com.merseyside.merseyLib.archy.android.presentation.di.stateViewModel
import com.merseyside.template.feature.news.presentation.NewsViewModel
import com.merseyside.template.fragments.main.view.NewsFragment
import com.merseyside.template.mppLibrary.NewsEventsDispatcher
import dev.icerock.moko.mvvm.dispatcher.eventsDispatcherOnMain
import org.koin.core.qualifier.named
import org.koin.dsl.module

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