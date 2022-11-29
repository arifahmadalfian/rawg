package com.arifahmadalfian.rawgapp.navigation

import androidx.navigation.*
import androidx.navigation.compose.composable
import coil.annotation.ExperimentalCoilApi
import com.arifahmadalfian.rawgapp.presentation.home.HomeScreen

@ExperimentalCoilApi
fun NavGraphBuilder.mainNavGraph(
    navController: NavHostController
) {
    navigation(
        route = BottomGraph.MAIN_ROUTE,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(BottomBarScreen.Home.route) {
            HomeScreen(navController = navController)
        }
    }
}