package com.route.newsapplication.data.manager

import com.route.newsapplication.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class LocalUserManagerImpl (

): LocalUserManager {
    override suspend fun saveAppEntry() {
        TODO("Not yet implemented")
    }

    override fun readAppEntry(): Flow<Boolean> {
        TODO("Not yet implemented")
    }
}