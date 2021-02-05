package com.merseyside.template.feature.list.domain.useCases

import com.merseyside.kmpMerseyLib.domain.coroutines.CoroutineUseCase

abstract class GetListUseCase<T> : CoroutineUseCase<List<T>, GetListUseCase.Params>() {

    data class Params(val param: String)
}