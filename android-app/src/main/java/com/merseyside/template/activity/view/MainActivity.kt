package com.merseyside.template.activity.view

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModel
import com.merseyside.archy.presentation.activity.BaseBindingActivity
import com.merseyside.template.R
import com.merseyside.template.databinding.ActivityMainBinding

class MainActivity: BaseBindingActivity<ActivityMainBinding>() {

    override fun performInjection(bundle: Bundle?) {}
    override fun getLayoutId() = R.layout.activity_main
    override fun getToolbar() = binding.toolbar
    override fun getFragmentContainer() = R.id.nav_host_fragment
}