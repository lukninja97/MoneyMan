package com.lukninja.moneyman.android.application

import android.app.Application
import com.lukninja.moneyman.android.di.provideAndroidModule
import com.lukninja.moneyman.db.appContext
import com.lukninja.moneyman.di.initKoin
import java.util.*

class MoneyManApplication: Application() {
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