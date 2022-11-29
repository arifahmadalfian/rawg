package com.arifahmadalfian.rawgapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import coil.annotation.ExperimentalCoilApi

@ExperimentalCoilApi
@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = BottomGraph.ROOT_ROUTE,
        startDestination = BottomGraph.MAIN_ROUTE
    ) {
        mainNavGraph(navController)
        favoriteNavGraph(navController)
        detailsNavGraph(navController)
    }
}

object BottomGraph {
    const val ROOT_ROUTE = "root_route"
    const val MAIN_ROUTE = "main_route"
    const val FAVORITE_ROUTE = "favorite_route"
    const val DETAILS_ROUTE = "details_route"
}