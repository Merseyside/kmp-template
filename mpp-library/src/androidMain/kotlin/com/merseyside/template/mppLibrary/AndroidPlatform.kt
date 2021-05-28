package com.merseyside.template.mppLibrary

import com.merseyside.template.core.db.Schema
import com.russhwolf.settings.AndroidSettings
import com.russhwolf.settings.Settings
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import org.koin.dsl.module

actual val platformModule = module {
    single<SqlDriver> {
        AndroidSqliteDriver(
            schema = Schema,
            context = get(),
            name = "templateDb.db"
        )
    }

    single<Settings> {
        AndroidSettings(get())
    }
}

actual val isDebug: Boolean = BuildConfig.DEBUG