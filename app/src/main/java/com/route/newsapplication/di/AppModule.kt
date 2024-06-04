package com.route.newsapplication.di

import android.app.Application
import com.route.newsapplication.data.manager.LocalUserManagerImpl
import com.route.newsapplication.domain.manager.LocalUserManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(application: Application) : LocalUserManager {
        return LocalUserManagerImpl(application)
    }
}