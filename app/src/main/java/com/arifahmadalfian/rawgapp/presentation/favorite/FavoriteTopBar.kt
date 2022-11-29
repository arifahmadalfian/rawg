package com.arifahmadalfian.rawgapp.presentation.favorite

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.arifahmadalfian.rawgapp.R
import com.arifahmadalfian.rawgapp.presentation.ui.theme.topAppBarBackgroundColor
import com.arifahmadalfian.rawgapp.presentation.ui.theme.topAppBarContentColor

@Composable
fun HomeTopBar() {
    TopAppBar(
        title = {
            Text(
                text = "Favorite Games",
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
    )
}