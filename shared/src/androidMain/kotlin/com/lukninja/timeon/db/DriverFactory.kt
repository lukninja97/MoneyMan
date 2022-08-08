package com.lukninja.timeon.db

import android.content.Context
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import com.timeon.database.TimeOnDatabase

lateinit var appContext: Context

actual fun createDriver(): SqlDriver {
    return AndroidSqliteDriver(TimeOnDatabase.Schema, appContext, "timeondatabase.db")
}