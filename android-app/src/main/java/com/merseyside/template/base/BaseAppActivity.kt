package com.merseyside.template.base

import androidx.databinding.ViewDataBinding
import com.merseyside.merseyLib.archy.android.presentation.activity.BaseVMActivity
import com.merseyside.merseyLib.archy.core.presentation.model.BaseViewModel

abstract class BaseAppActivity<V: ViewDataBinding, M: BaseViewModel>: BaseVMActivity<V, M>()