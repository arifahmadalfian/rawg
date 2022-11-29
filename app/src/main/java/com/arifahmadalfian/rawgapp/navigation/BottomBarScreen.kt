package com.arifahmadalfian.rawgapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.arifahmadalfian.rawgapp.navigation.BottomGraph.DETAILS_ROUTE

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomBarScreen("home", "Home", Icons.Default.Home)
    object Favorite : BottomBarScreen("favorite", "Favorite", Icons.Default.Favorite)
}

sealed class Screen(val route: String) {
    object Details : Screen("details")
}