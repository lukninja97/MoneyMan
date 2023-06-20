package com.lukninja.moneyman.db

import android.content.Context
import com.moneyman.database.MoneyManDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

lateinit var appContext: Context

actual fun createDriver(): SqlDriver {
    return AndroidSqliteDriver(MoneyManDatabase.Schema, appContext, "moneymandatabase.db")
}