package com.merseyside.template.base

import androidx.databinding.ViewDataBinding
import com.merseyside.kmpMerseyLib.arch.presentation.activity.BaseVMActivity
import com.merseyside.kmpMerseyLib.arch.presentation.di.BaseViewModel

abstract class BaseAppActivity<V: ViewDataBinding, M: BaseViewModel>: BaseVMActivity<V, M>()