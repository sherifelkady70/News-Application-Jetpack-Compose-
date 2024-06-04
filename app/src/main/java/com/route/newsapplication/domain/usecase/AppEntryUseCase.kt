package com.route.newsapplication.domain.usecase

data class AppEntryUseCase(
    val saveLocalUserData : SaveEntryUseCase,
    val readLocalUserData : ReadAppEntryUseCase
)
