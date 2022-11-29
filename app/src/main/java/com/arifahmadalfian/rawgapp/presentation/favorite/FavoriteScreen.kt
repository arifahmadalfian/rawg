package com.arifahmadalfian.rawgapp.presentation.favorite

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.BottomSheetScaffoldDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import com.arifahmadalfian.rawgapp.domain.model.entity.toResultItem
import com.arifahmadalfian.rawgapp.presentation.components.EmptyScreen
import com.arifahmadalfian.rawgapp.presentation.components.ListContent

@ExperimentalCoilApi
@Composable
fun FavoriteScreen(
    navController: NavHostController,
    viewModel: FavoriteViewModel = hiltViewModel()
) {

    Scaffold(
        modifier = Modifier
            .padding(bottom = BottomSheetScaffoldDefaults.SheetPeekHeight),
        topBar = {
            HomeTopBar()
        },
        content = {
            if (viewModel.emptyState.value) {
                EmptyScreen()
            } else {
                ListContent(
                    resultItems = viewModel.favoriteGames.collectAsState(initial = emptyList()).value.toResultItem(),
                    navController = navController,
                    fromFavorite = true,
                    isLoading = false,
                ) {}
            }
        }
    )
}


