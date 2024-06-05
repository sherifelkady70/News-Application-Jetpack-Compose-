package com.route.newsapplication.presentation.onboarding

import androidx.lifecycle.ViewModel
import com.route.newsapplication.domain.usecase.AppEntryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val appEntryUseCase : AppEntryUseCase
) : ViewModel(){

}