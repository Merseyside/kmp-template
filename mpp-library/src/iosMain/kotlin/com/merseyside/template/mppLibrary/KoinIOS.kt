package com.merseyside.template.mppLibrary

import com.merseyside.template.core.db.TemplateDatabase
import com.russhwolf.settings.AppleSettings
import com.russhwolf.settings.Settings
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import org.koin.core.KoinApplication
import org.koin.dsl.module
import platform.Foundation.NSUserDefaults

fun initKoinIos(
    userDefaults: NSUserDefaults
): KoinApplication = initKoin(
    module {
        single<Settings> { AppleSettings(userDefaults) }
    }
)

actual val platformModule = module {
    single<SqlDriver> { NativeSqliteDriver(TemplateDatabase.Schema, "templateDb") }
}