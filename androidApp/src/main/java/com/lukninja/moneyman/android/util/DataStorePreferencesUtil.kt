package com.lukninja.moneyman.android.util

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class DataStorePreferencesUtil(private val context: Context) {
    companion object {
        const val APP_PREFERENCES = "settings"
    }

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
        name = APP_PREFERENCES
    )

    suspend fun saveDataBoolean(
        prefsKey: Preferences.Key<Boolean>,
        value: Boolean
    ) {
        context.dataStore.edit { settings ->
            settings[prefsKey] = value
        }
    }

    suspend fun readDataBoolean(
        prefsKey: Preferences.Key<Boolean>
    ): Boolean {
        return context.dataStore.data.first()[prefsKey] ?: false
    }

    fun readDataBooleanFlow(
        prefsKey: Preferences.Key<Boolean>
    ) = context.dataStore.data.map { preferences ->
        preferences[prefsKey] ?: false
    }

    suspend fun saveDataInt(
        prefsKey: Preferences.Key<Int>,
        value: Int
    ) {
        context.dataStore.edit { settings ->
            settings[prefsKey] = value
        }
    }

    suspend fun readDataInt(
        prefsKey: Preferences.Key<Int>
    ): Int {
        return context.dataStore.data.first()[prefsKey] ?: 0
    }

    fun readDataIntFlow(
        prefsKey: Preferences.Key<Int>
    ) = context.dataStore.data.map { preferences ->
        preferences[prefsKey] ?: 0
    }

    suspend fun saveDataString(
        prefsKey: Preferences.Key<String>,
        value: String
    ) {
        context.dataStore.edit { settings ->
            settings[prefsKey] = value
        }
    }

    suspend fun readDataString(
        prefsKey: Preferences.Key<String>
    ): String {
        return context.dataStore.data.first()[prefsKey] ?: ""
    }

    fun readDataStringFlow(
        prefsKey: Preferences.Key<String>
    ) = context.dataStore.data.map { preferences ->
        preferences[prefsKey] ?: ""
    }
}