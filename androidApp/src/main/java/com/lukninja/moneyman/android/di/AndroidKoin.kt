package com.lukninja.moneyman.android.di

import android.content.Context
import com.lukninja.moneyman.android.util.DataStorePreferencesUtil
import org.koin.core.module.Module
import org.koin.dsl.module

fun provideAndroidModule(context: Context): Module {
    return module {
        single { DataStorePreferencesUtil(context) }
    }
}