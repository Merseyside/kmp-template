package com.merseyside.template.mppLibrary

import com.merseyside.template.feature.list.presentation.ListViewModel
import com.merseyside.template.domain.entity.News
import dev.icerock.moko.mvvm.dispatcher.EventsDispatcher

/* News feature */
typealias NewsViewModel = ListViewModel<News>
typealias NewsEventsListener = ListViewModel.EventsListener
typealias NewsEventsDispatcher = EventsDispatcher<ListViewModel.EventsListener>