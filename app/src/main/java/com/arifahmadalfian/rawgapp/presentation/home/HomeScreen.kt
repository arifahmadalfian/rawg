package com.arifahmadalfian.rawgapp.presentation.home

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.BottomSheetScaffoldDefaults
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import com.arifahmadalfian.rawgapp.presentation.components.ListContent
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.delay

@ExperimentalCoilApi
@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {

    var isRefreshing by remember { mutableStateOf(false) }
    LaunchedEffect(key1 = isRefreshing) {
        if (isRefreshing) {
            delay(1000)
            isRefreshing = false
        }
    }

    var isSearch by remember {
        mutableStateOf(false)
    }

    Scaffold(
        modifier = Modifier
            .padding(bottom = BottomSheetScaffoldDefaults.SheetPeekHeight),
        topBar = {
            if (isSearch) {
                SearchTopBar(
                    text = viewModel.searchGame ?: "",
                    onTextChange = {
                        viewModel.searchGame = it
                    },
                    onSearchClicked = {
                        viewModel.reset()
                        viewModel.loadNextItems()
                    },
                    onCloseClicked = {
                        isSearch = false
                    }
                )
            } else {
                HomeTopBar(
                    onSearchClick = {
                        isSearch = true
                    }
                )
            }
        },
        content = {
            SwipeRefresh(
                swipeEnabled = true,
                state = rememberSwipeRefreshState(isRefreshing = isRefreshing),
                onRefresh = {
                    isRefreshing = true
                    viewModel.reset()
                }
            ) {
                ListContent(
                    resultItems = viewModel.gameState.items,
                    navController = navController,
                    isLoading = viewModel.gameState.isLoading,
                ) {
                    viewModel.loadNextItems()
                }
            }
        }
    )
}