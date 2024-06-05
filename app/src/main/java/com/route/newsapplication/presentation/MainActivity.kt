package com.route.newsapplication.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.route.newsapplication.MainViewModel
import com.route.newsapplication.domain.usecase.AppEntryUseCase
import com.route.newsapplication.presentation.navgraph.NavGraph
import com.route.newsapplication.presentation.onboarding.OnBoardingEvent
import com.route.newsapplication.presentation.onboarding.OnBoardingScreen
import com.route.newsapplication.presentation.onboarding.OnBoardingViewModel
import com.route.newsapplication.ui.theme.NewsApplicationTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val mainViewModel by viewModels<MainViewModel>()
    @Inject
    lateinit var userAppEntry : AppEntryUseCase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window,false)
        lifecycleScope.launch {
            userAppEntry.readLocalUserData.invoke().collect{
                Log.d("test read local user",it.toString())
            }
        }
        
        installSplashScreen().apply {
            setKeepOnScreenCondition{
                mainViewModel.splashCondition
            }
        }
        setContent {
            NewsApplicationTheme (
                dynamicColor = false
            ) {
                val isSystemIsDarkMode = isSystemInDarkTheme()
                val systemUiController = rememberSystemUiController()

                SideEffect {
                    systemUiController.setSystemBarsColor(
                        color = Color.Transparent,
                        darkIcons = !isSystemIsDarkMode
                    )
                }

                Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)){
                    val startDestination = mainViewModel.startDestination
                    NavGraph(startDestination = startDestination)
                }
            }
        }
    }
}

