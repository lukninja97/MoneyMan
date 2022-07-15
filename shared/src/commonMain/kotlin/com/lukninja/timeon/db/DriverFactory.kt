package com.lukninja.timeon.db

import com.squareup.sqldelight.db.SqlDriver
import com.yourappname.database.YourAppNameDatabase

expect fun createDriver(): SqlDriver

class DriverFactory {
    fun createDatabase(): YourAppNameDatabase {
        val driver = createDriver()
        return YourAppNameDatabase(driver)
    }
}
