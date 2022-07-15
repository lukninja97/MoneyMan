package com.lukninja.timeon.db

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import com.yourappname.database.YourAppNameDatabase

actual fun createDriver(): SqlDriver {
    return NativeSqliteDriver(YourAppNameDatabase.Schema, "yourappdatabasename.db")
}