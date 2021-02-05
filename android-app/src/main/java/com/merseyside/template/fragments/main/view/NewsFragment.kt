package com.merseyside.template.fragments.main.view

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.merseyside.adapters.base.onItemClicked
import com.merseyside.template.BR
import com.merseyside.template.R
import com.merseyside.template.base.BaseAppFragment
import com.merseyside.template.databinding.FragmentNewsBinding
import com.merseyside.template.domain.entity.News
import com.merseyside.template.fragments.main.adapter.NewsAdapter
import com.merseyside.template.mppLibrary.NewsEventsListener
import com.merseyside.template.mppLibrary.NewsViewModel
import com.merseyside.utils.openUrl

class NewsFragment: BaseAppFragment<FragmentNewsBinding, NewsViewModel, NewsEventsListener>(),
    NewsEventsListener {

    private val adapter = NewsAdapter().apply {
        onItemClicked { openUrl(requireActivity(), it.url) }
    }

    override fun getBindingVariable() = BR.viewModel
    override fun getLayoutId() = R.layout.fragment_news
    override fun getTitle(context: Context) = getString(R.string.template)

    private val newsObserver = Observer<List<News>> {
        adapter.add(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.news.adapter = adapter
        viewModel.getList().ld().observe(viewLifecycleOwner, newsObserver)
    }

    override fun routeToMainScreen() {
        navigate(R.id.news_fragment)
    }
}