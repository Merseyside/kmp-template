package com.merseyside.template.di

import android.content.Context
import android.content.SharedPreferences
import org.koin.dsl.module

val appModule = module {

    single<SharedPreferences> {
        get<Context>().getSharedPreferences("TEMPLATE_SETTINGS", Context.MODE_PRIVATE)
    }
}