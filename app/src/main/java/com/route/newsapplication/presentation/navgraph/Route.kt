package com.route.newsapplication.presentation.navgraph

sealed class Route(
    val route : String
) {

    object OnBoardingScreen : Route( "onBoardingScreen")
    object HomeScreen : Route("homeScreen")
    object SearchScreen : Route("searchScreen")
    object BookMarkScreen : Route("bookMarkScreen")
    object DetailsScreen : Route("detailsScreen")
    object AppStartNavigation : Route("appStartNav")
    object NewsNavigation : Route("newsNavigation")
    object NewsNavigator : Route("newsNavigator")
}