package com.merseyside.template.mppLibrary

import com.merseyside.kmpMerseyLib.utils.db.DBAndroidHelper
import com.merseyside.template.data.db.TemplateDatabase
import com.russhwolf.settings.AndroidSettings
import com.russhwolf.settings.Settings
import org.koin.dsl.module

actual val platformModule = module {
    single {
        DBAndroidHelper(
            context = get(),
            sqlDriverSchema = TemplateDatabase.Schema,
            dbName = "templateDb.db",
            version = 1
        ).createDriver()
    }

    single<Settings> {
        AndroidSettings(get())
    }
}


actual val isDebug: Boolean = BuildConfig.DEBUG