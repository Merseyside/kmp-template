package com.merseyside.template.base

import androidx.databinding.ViewDataBinding
import com.merseyside.kmpMerseyLib.presentation.fragment.BaseVMEventsFragment
import com.merseyside.kmpMerseyLib.presentation.di.BaseViewModel

abstract class BaseAppFragment<V: ViewDataBinding, M: BaseViewModel, Listener: Any>: BaseVMEventsFragment<V, M, Listener>()