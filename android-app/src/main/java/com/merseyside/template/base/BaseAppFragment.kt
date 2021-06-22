package com.merseyside.template.base

import androidx.databinding.ViewDataBinding
import com.merseyside.merseyLib.archy.android.presentation.fragment.BaseVMEventsFragment
import com.merseyside.merseyLib.archy.core.presentation.model.BaseViewModel

abstract class BaseAppFragment<V: ViewDataBinding, M: BaseViewModel, Listener: Any>: BaseVMEventsFragment<V, M, Listener>()