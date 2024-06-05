package com.route.newsapplication.presentation.onboarding

sealed class OnBoardingEvent {
    data object SaveEntryEvent : OnBoardingEvent()
}