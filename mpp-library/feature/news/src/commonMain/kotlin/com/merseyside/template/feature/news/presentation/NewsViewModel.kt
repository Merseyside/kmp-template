package com.merseyside.template.feature.news.presentation

import com.merseyside.kmpMerseyLib.arch.presentation.di.StateViewModel
import com.merseyside.kmpMerseyLib.utils.SavedState
import com.merseyside.kmpMerseyLib.utils.ext.log
import com.merseyside.kmpMerseyLib.utils.ext.logMsg
import com.merseyside.template.domain.entity.News
import com.merseyside.template.domain.useCases.GetNewsUseCase
import dev.icerock.moko.mvvm.dispatcher.EventsDispatcher
import dev.icerock.moko.mvvm.dispatcher.EventsDispatcherOwner
import dev.icerock.moko.mvvm.livedata.LiveData
import dev.icerock.moko.mvvm.livedata.MutableLiveData

class NewsViewModel(
    override val eventsDispatcher: EventsDispatcher<EventsListener>,
    private val getListUseCase: GetNewsUseCase
) : StateViewModel(), EventsDispatcherOwner<NewsViewModel.EventsListener> {

    private val listLiveData = MutableLiveData(initialValue = emptyList<News>())
    fun getList(): LiveData<List<News>> = listLiveData

    init {
        getNewsList()
    }

    private fun getNewsList() {
        getListUseCase.execute(
            params = GetNewsUseCase.Params(param = "something_useful"),
            onComplete = { listLiveData.value = it }
        )
    }

    interface EventsListener {
        fun routeToMainScreen()
    }

    override fun onRestoreState(savedState: SavedState) {
        savedState.getInt("value").log()
        logMsg("onRestore")
    }

    override fun onSaveState(savedState: SavedState) {
        logMsg("onSave")
        savedState.put("value", 50)
    }

    override fun onCleared() {
        super.onCleared()

        logMsg("onCleared")
    }
}
