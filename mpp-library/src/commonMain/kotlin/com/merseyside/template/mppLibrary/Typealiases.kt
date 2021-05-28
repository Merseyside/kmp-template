package com.merseyside.template.mppLibrary

import com.merseyside.template.feature.news.presentation.NewsViewModel
import dev.icerock.moko.mvvm.dispatcher.EventsDispatcher

/* News feature */
typealias NewsEventsListener = NewsViewModel.EventsListener
typealias NewsEventsDispatcher = EventsDispatcher<NewsViewModel.EventsListener>
/**/