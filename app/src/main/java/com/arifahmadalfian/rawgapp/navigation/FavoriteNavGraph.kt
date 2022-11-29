package com.arifahmadalfian.rawgapp.navigation

import androidx.navigation.*
import androidx.navigation.compose.composable
import coil.annotation.ExperimentalCoilApi
import com.arifahmadalfian.rawgapp.presentation.favorite.FavoriteScreen

@ExperimentalCoilApi
fun NavGraphBuilder.favoriteNavGraph(
    navController: NavHostController
) {
    navigation(
        route = BottomGraph.FAVORITE_ROUTE,
        startDestination = BottomBarScreen.Favorite.route
    ) {
        composable(BottomBarScreen.Favorite.route) {
            FavoriteScreen(navController = navController)
        }
    }
}