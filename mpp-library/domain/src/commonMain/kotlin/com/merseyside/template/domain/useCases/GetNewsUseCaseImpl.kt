package com.merseyside.template.domain.useCases

import com.merseyside.template.feature.list.domain.useCases.GetListUseCase
import com.merseyside.template.domain.entity.News
import com.merseyside.template.domain.repository.NewsRepository

class GetNewsUseCaseImpl(private val repository: NewsRepository) : GetListUseCase<News>() {

    override suspend fun executeOnBackground(params: Params?): List<News> {
        return repository.getNews()
    }
}