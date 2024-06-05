package com.route.newsapplication.domain.usecase

import com.route.newsapplication.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntryUseCase(
    private val localUserManager : LocalUserManager
) {
     operator fun invoke() : Flow<Boolean> {
        return localUserManager.readAppEntry()
    }
}