package com.merseyside.template.fragments.main.adapter

import com.merseyside.adapters.base.BaseAdapter
import com.merseyside.template.R
import com.merseyside.template.BR
import com.merseyside.template.domain.entity.News
import com.merseyside.template.fragments.main.model.NewsItemViewModel

class NewsAdapter : BaseAdapter<News, NewsItemViewModel>() {
    override fun getLayoutIdForPosition(position: Int) = R.layout.view_news
    override fun getBindingVariable() = BR.viewModel
    override fun createItemViewModel(obj: News) = NewsItemViewModel(obj)
}