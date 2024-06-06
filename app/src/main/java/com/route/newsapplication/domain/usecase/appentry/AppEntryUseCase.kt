package com.route.newsapplication.domain.usecase.appentry

data class AppEntryUseCase(
    val saveLocalUserData : SaveEntryUseCase,
    val readLocalUserData : ReadAppEntryUseCase
)
