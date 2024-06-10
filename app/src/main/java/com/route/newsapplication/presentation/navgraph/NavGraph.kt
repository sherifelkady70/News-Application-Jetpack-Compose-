package com.route.newsapplication.presentation.navgraph

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.route.newsapplication.presentation.home.HomeScreen
import com.route.newsapplication.presentation.home.HomeViewModel
import com.route.newsapplication.presentation.onboarding.OnBoardingScreen
import com.route.newsapplication.presentation.onboarding.OnBoardingViewModel

@Composable
fun NavGraph(
    startDestination : String
){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination ){

        navigation(route = Route.AppStartNavigation.route ,
            startDestination = Route.OnBoardingScreen.route){
            composable(route = Route.OnBoardingScreen.route){
                val viewModel : OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen {
                    viewModel.onEvent(it)
                }
            }
        }
        
        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigator.route
        ){
            composable(
                route = Route.NewsNavigator.route
            ){
                val homeViewModel : HomeViewModel= hiltViewModel()
                val articles = homeViewModel.news.collectAsLazyPagingItems()
                Log.d("result of Api","articles passed in Home Screen $articles")
                HomeScreen(articles = articles,{})
            }
        }
    }
}