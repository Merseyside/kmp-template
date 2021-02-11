package com.merseyside.template

import com.merseyside.archy.BaseApplication
import com.merseyside.template.di.appModule
import com.merseyside.template.fragments.main.di.mainModule
import com.merseyside.template.mppLibrary.initKoin
import org.koin.android.ext.koin.androidContext

class MainApplication : BaseApplication() {
    override fun onCreate() {
        super.onCreate()
        initDI()
    }

    private fun initDI() {
        initKoin(
            appModule,
            mainModule
        ) {
            androidContext(this@MainApplication)
        }
    }
}
