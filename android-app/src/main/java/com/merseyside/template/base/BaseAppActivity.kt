package com.merseyside.template.base

import androidx.databinding.ViewDataBinding
import com.merseyside.kmpMerseyLib.presentation.activity.BaseVMActivity
import com.merseyside.kmpMerseyLib.presentation.di.BaseViewModel

abstract class BaseAppActivity<V: ViewDataBinding, M: BaseViewModel>: BaseVMActivity<V, M>()