package com.route.newsapplication.data.manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.route.newsapplication.domain.manager.LocalUserManager
import com.route.newsapplication.util.Constants
import com.route.newsapplication.util.Constants.APP_ENTRY
import com.route.newsapplication.util.Constants.USER_SETTINGS
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalUserManagerImpl (
    private val context : Context
): LocalUserManager {
    override suspend fun saveAppEntry() {
       context.dataStore.edit { settingsPreference ->
           settingsPreference[PreferencesKey.APP_ENTRY] = true
       }
    }

    override fun readAppEntry(): Flow<Boolean> {
        return context.dataStore.data.map {
            it[PreferencesKey.APP_ENTRY] ?: false
        }
    }
}

private val Context.dataStore : DataStore<Preferences> by preferencesDataStore(name = USER_SETTINGS)

private object PreferencesKey {
    val APP_ENTRY = booleanPreferencesKey(name = Constants.APP_ENTRY)
}