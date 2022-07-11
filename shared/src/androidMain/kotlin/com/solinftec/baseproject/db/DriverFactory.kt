package com.solinftec.baseproject.db

import android.content.Context
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import com.yourappname.database.YourAppNameDatabase

lateinit var appContext: Context

actual fun createDriver(): SqlDriver {
    return AndroidSqliteDriver(YourAppNameDatabase.Schema, appContext, "yourappdatabasename.db")
}