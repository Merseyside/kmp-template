package com.merseyside.template.domain.useCases

import com.merseyside.merseyLib.archy.core.domain.coroutines.CoroutineUseCase
import com.merseyside.template.domain.entity.News
import com.merseyside.template.domain.repository.NewsRepository

class GetNewsUseCase(private val repository: NewsRepository)
    : CoroutineUseCase<List<News>, GetNewsUseCase.Params>() {

    override suspend fun executeOnBackground(params: Params?): List<News> {
        return repository.getNews()
    }

    data class Params(val param: String)
}