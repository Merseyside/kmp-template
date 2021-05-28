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
//        teamAdapter = Team.Adapter(
//            foundedAdapter = DateAdapter()
//        ),
//        playerAdapter = Player.Adapter(
//            shootsAdapter = EnumColumnAdapter(),
//            positionAdapter = EnumColumnAdapter(),
//            birth_dateAdapter = DateAdapter()
//        )
    )
}

object Schema: SqlDriver.Schema by TemplateDatabase.Schema {
    override fun create(driver: SqlDriver) {
        TemplateDatabase.Schema.create(driver)

        createQueryWrapper(driver).apply {

        }
    }
}