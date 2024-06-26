package com.route.newsapplication.di

import android.app.Application
import android.util.Log
import com.route.newsapplication.data.manager.LocalUserManagerImpl
import com.route.newsapplication.data.remote.NewsWebService
import com.route.newsapplication.data.repository.NewsRepositoryImpl
import com.route.newsapplication.domain.manager.LocalUserManager
import com.route.newsapplication.domain.repository.NewsRepository
import com.route.newsapplication.domain.usecase.appentry.AppEntryUseCase
import com.route.newsapplication.domain.usecase.appentry.ReadAppEntryUseCase
import com.route.newsapplication.domain.usecase.appentry.SaveEntryUseCase
import com.route.newsapplication.domain.usecase.news.GetNews
import com.route.newsapplication.domain.usecase.news.NewsUseCases
import com.route.newsapplication.domain.usecase.news.SearchInNews
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(application: Application) : LocalUserManager {
        return LocalUserManagerImpl(application)
    }

    @Provides
    @Singleton
    fun providesAppEntryUseCases(localUserManager: LocalUserManager) =
        AppEntryUseCase(
            saveLocalUserData = SaveEntryUseCase(localUserManager) ,
            readLocalUserData = ReadAppEntryUseCase(localUserManager)
        )

    @Singleton
    @Provides
    fun provideInterceptors() : HttpLoggingInterceptor{
        return HttpLoggingInterceptor{
            Log.e("API",it)
        }.apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }
    @Provides
    @Singleton
    fun okHttpClint(loggingInterceptor : HttpLoggingInterceptor) : OkHttpClient{
        return OkHttpClient
            .Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }
    @Provides
    @Singleton
    fun provideGsonConverterFactory():GsonConverterFactory{
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient,gsonConverterFactory: GsonConverterFactory) : Retrofit {
        return Retrofit
            .Builder()
            .addConverterFactory(gsonConverterFactory)
            .baseUrl("https://newsapi.org/v2/")
            .client(okHttpClient)
            .build()
    }
    @Provides
    @Singleton
    fun provideNewsWebService(retrofit: Retrofit) : NewsWebService {
        return retrofit.create(NewsWebService::class.java)
    }
    @Provides
    @Singleton
    fun providesNewsRepository(newsWebService: NewsWebService) : NewsRepository {
        return NewsRepositoryImpl(newsWebService)
    }
    @Provides
    @Singleton
    fun providesNewsUseCases(newsRepo : NewsRepository) : NewsUseCases {
        return NewsUseCases(getNews = GetNews(newsRepo),
            searchInNews = SearchInNews(newsRepo))
    }
}