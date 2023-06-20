package com.lukninja.moneyman.db

import com.moneyman.database.MoneyManDatabase
import com.squareup.sqldelight.db.SqlDriver

expect fun createDriver(): SqlDriver

class DriverFactory {
    fun createDatabase(): MoneyManDatabase {
        val driver = createDriver()
        return MoneyManDatabase(driver)
    }
}
