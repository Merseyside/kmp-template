package com.merseyside.template.domain.db

import com.merseyside.template.data.db.TemplateDatabase
import com.squareup.sqldelight.db.SqlDriver
import kotlinx.coroutines.CoroutineDispatcher

class DatabaseHelper(
    sqlDriver: SqlDriver,
    private val backgroundDispatcher: CoroutineDispatcher
) {

    private val db: TemplateDatabase = createDatabase(sqlDriver)

    fun createDatabase(driver: SqlDriver): TemplateDatabase {

        return TemplateDatabase(driver)
    }
}