package com.lukninja.moneyman.db

import com.moneyman.database.MoneyManDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
actual fun createDriver(): SqlDriver {
    return NativeSqliteDriver(MoneyManDatabase.Schema, "moneymandatabase.db")
}