package com.merseyside.template.fragments.main.model

import androidx.databinding.Bindable
import com.merseyside.adapters.model.BaseAdapterViewModel
import com.merseyside.template.domain.entity.News

class NewsItemViewModel(obj: News): BaseAdapterViewModel<News>(obj) {

    override fun areItemsTheSame(obj: News): Boolean {
        return false
    }

    override fun notifyUpdate() {}

    @Bindable
    fun getTitle(): String {
        return obj.title
    }

    @Bindable
    fun getAuthor(): String {
        return obj.author ?: "No author"
    }

    @Bindable
    fun getDescription(): String {
        return obj.description
    }

    @Bindable
    fun getImageUrl(): String? {
        return obj.imageUrl
    }
}