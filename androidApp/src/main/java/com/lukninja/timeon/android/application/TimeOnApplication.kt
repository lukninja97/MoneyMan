package com.lukninja.timeon.android.application

import android.app.Application
import com.lukninja.timeon.android.di.provideAndroidModule
import com.lukninja.timeon.db.appContext
import com.lukninja.timeon.di.initKoin
import java.util.*

class TimeOnApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        initKoin(
            countryCode = Locale.getDefault().country,
            regionCode = Locale.getDefault().language,
            androidModule = provideAndroidModule(applicationContext)
        )
    }
}