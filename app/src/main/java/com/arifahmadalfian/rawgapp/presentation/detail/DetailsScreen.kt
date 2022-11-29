package com.arifahmadalfian.rawgapp.presentation.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import com.arifahmadalfian.rawgapp.domain.model.dto.GameDetailDto
import com.arifahmadalfian.rawgapp.domain.model.entity.toGameEntity
import com.arifahmadalfian.rawgapp.domain.model.entity.toResultItem
import com.arifahmadalfian.rawgapp.domain.utils.verticalGradientBackground
import com.arifahmadalfian.rawgapp.presentation.components.DetailsShimmer
import timber.log.Timber

@ExperimentalCoilApi
@Composable
fun DetailsScreen(
    navController: NavHostController,
    viewModel: DetailsViewModel = hiltViewModel(),
    gameId: Int,
) {
    LaunchedEffect(key1 = gameId) {
        viewModel.detailGame(gameId)
    }

    var gameDetails by remember {
        mutableStateOf(GameDetailDto())
    }

    var isFavorite by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = viewModel.gameDetail.data) {
        viewModel.gameDetail.data?.let {
            gameDetails = it
        }
    }

    viewModel.favoriteGames.collectAsState(initial = emptyList()).value.let { list ->
        list.forEach { game ->
            if (game.id == gameId) {
                isFavorite = true
                Timber.d("isFavorite: $isFavorite")
            }
        }
    }

    val scrollState = rememberScrollState(0)

    val dominantColors = listOf(Color.White, MaterialTheme.colors.surface)
    val dominantGradient = remember { dominantColors }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalGradientBackground(dominantGradient)
    ) {
        if (viewModel.gameDetail.data == null) {
            DetailsShimmer()
        } else {
            BoxTopSection(gameDetail = gameDetails, scrollState = scrollState)
            BottomScrollableContent(gameDetail = gameDetails, scrollState = scrollState)
        }
        AnimatedToolBar(
            gameDetail = gameDetails,
            scrollState = scrollState,
            isFavorite = isFavorite,
            onFavoriteClicked = {
                if (it) {
                    viewModel.addGameFavorite(gameDetails.toGameEntity())
                } else {
                    gameDetails.id?.let { it1 -> viewModel.deleteGameFavorite(it1) }
                }
            },
            onBack = {
                navController.popBackStack()
            }
        )
    }

}