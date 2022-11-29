package com.arifahmadalfian.rawgapp.navigation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.*
import androidx.navigation.compose.composable
import coil.annotation.ExperimentalCoilApi
import com.arifahmadalfian.rawgapp.domain.utils.DETAILS_GAME_ID
import com.arifahmadalfian.rawgapp.presentation.detail.DetailsScreen

@ExperimentalCoilApi
fun NavGraphBuilder.detailsNavGraph(
    navController: NavHostController
) {
    navigation(
        route = BottomGraph.DETAILS_ROUTE,
        startDestination = Screen.Details.route,
    ) {
        composable(
            route = Screen.Details.route,
            arguments = listOf(navArgument(DETAILS_GAME_ID) {
                type = NavType.StringType
            })
        ) {
            val gameId by remember {
                mutableStateOf(navController.previousBackStackEntry?.savedStateHandle?.get<Int>(DETAILS_GAME_ID) ?: 0)
            }
            DetailsScreen(
                navController = navController,
                gameId = gameId
            )
        }
    }
}