package com.arifahmadalfian.rawgapp.presentation.home

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.arifahmadalfian.rawgapp.R
import com.arifahmadalfian.rawgapp.presentation.ui.theme.topAppBarBackgroundColor
import com.arifahmadalfian.rawgapp.presentation.ui.theme.topAppBarContentColor

@Composable
fun HomeTopBar(
    onSearchClick: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = "Games For You",
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
        actions = {
            IconButton(onClick = onSearchClick) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(R.string.search_icon)
                )
            }
        }
    )
}