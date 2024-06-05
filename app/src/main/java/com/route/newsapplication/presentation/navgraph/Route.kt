package com.route.newsapplication.presentation.navgraph

sealed class Route(
    route : String
) {

    data object OnBoardingScreen : Route("onBoardingScreen")
    data object HomeScreen : Route("homeScreen")
    data object SearchScreen : Route("searchScreen")
    data object BookMarkScreen : Route("bookMarkScreen")
    data object DetailsScreen : Route("detailsScreen")
    data object AppStartNavigation : Route("appStartNav")
    data object NewsNavigation : Route("newsNavigation")
    data object NewsNavigator : Route("newsNavigator")
}