package com.lukninja.timeon.db

import com.squareup.sqldelight.db.SqlDriver
import com.timeon.database.TimeOnDatabase

expect fun createDriver(): SqlDriver

class DriverFactory {
    fun createDatabase(): TimeOnDatabase {
        val driver = createDriver()
        return TimeOnDatabase(driver)
    }
}
