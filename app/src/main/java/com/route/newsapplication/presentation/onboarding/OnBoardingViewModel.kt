package com.route.newsapplication.presentation.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.newsapplication.domain.usecase.appentry.AppEntryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val appEntryUseCase : AppEntryUseCase
) : ViewModel(){


    fun onEvent(event: OnBoardingEvent){
        when(event){
            is OnBoardingEvent.SaveEntryEvent -> {
                saveEntryApp()
            }
        }
    }

    private fun saveEntryApp() {
        viewModelScope.launch{
            appEntryUseCase.saveLocalUserData.invoke()
        }
    }
}