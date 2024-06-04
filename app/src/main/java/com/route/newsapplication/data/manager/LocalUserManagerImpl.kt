package com.route.newsapplication.data.manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.route.newsapplication.domain.manager.LocalUserManager
import com.route.newsapplication.util.Constants.USER_SETTINGS
import kotlinx.coroutines.flow.Flow

class LocalUserManagerImpl (
    private val context : Context
): LocalUserManager {
    override suspend fun saveAppEntry() {
        TODO("Not yet implemented")
    }

    override fun readAppEntry(): Flow<Boolean> {
        TODO("Not yet implemented")
    }
}

private val Context.dataStore : DataStore<Preferences> by preferencesDataStore(name = USER_SETTINGS)