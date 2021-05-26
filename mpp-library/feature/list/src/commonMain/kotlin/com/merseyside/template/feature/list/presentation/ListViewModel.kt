package com.merseyside.template.feature.list.presentation

import com.merseyside.kmpMerseyLib.arch.presentation.di.StateViewModel
import com.merseyside.kmpMerseyLib.utils.SavedState
import com.merseyside.kmpMerseyLib.utils.ext.log
import com.merseyside.kmpMerseyLib.utils.ext.logMsg
import com.merseyside.template.feature.list.domain.useCases.GetListUseCase
import dev.icerock.moko.mvvm.dispatcher.EventsDispatcher
import dev.icerock.moko.mvvm.dispatcher.EventsDispatcherOwner
import dev.icerock.moko.mvvm.livedata.LiveData
import dev.icerock.moko.mvvm.livedata.MutableLiveData

class ListViewModel<T>(
    override val eventsDispatcher: EventsDispatcher<EventsListener>,
    private val getListUseCase: GetListUseCase<T>
) : StateViewModel(), EventsDispatcherOwner<ListViewModel.EventsListener> {

    private val listLiveData = MutableLiveData(initialValue = emptyList<T>())
    fun getList(): LiveData<List<T>> = listLiveData

    init {
        getNewsList()
    }

    private fun getNewsList() {
        getListUseCase.execute(
            params = GetListUseCase.Params(param = "something_useful"),
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
}
