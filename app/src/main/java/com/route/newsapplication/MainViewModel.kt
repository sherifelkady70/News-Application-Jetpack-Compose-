package com.route.newsapplication

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.route.newsapplication.domain.usecase.AppEntryUseCase
import com.route.newsapplication.presentation.navgraph.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val appEntryUseCase: AppEntryUseCase
): ViewModel() {

    var splashCondition by mutableStateOf(true)
        private set

    var startDestination by mutableStateOf(Route.AppStartNavigation.route)
        private set


    init {
        appEntryUseCase.readLocalUserData.invoke().onEach { shouldStartFromHomeScreen ->
            if(shouldStartFromHomeScreen){
                startDestination= Route.NewsNavigation.route
            }else{
                startDestination = Route.AppStartNavigation.route
            }
            delay(300)
            splashCondition = false
        }
    }

}
