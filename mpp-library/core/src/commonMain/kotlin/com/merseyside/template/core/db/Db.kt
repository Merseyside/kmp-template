package com.merseyside.template.core.db

import com.squareup.sqldelight.db.SqlDriver
import kotlinx.coroutines.CoroutineDispatcher

class DatabaseHelper(
    sqlDriver: SqlDriver,
    private val backgroundDispatcher: CoroutineDispatcher
) {

    private val db: TemplateDatabase = createQueryWrapper(sqlDriver)
}

private fun createQueryWrapper(driver: SqlDriver): TemplateDatabase {
    return TemplateDatabase(
        driver = driver
    )
}

object Schema: SqlDriver.Schema by TemplateDatabase.Schema {
    override fun create(driver: SqlDriver) {
        TemplateDatabase.Schema.create(driver)

        createQueryWrapper(driver).apply {

        }
    }
}