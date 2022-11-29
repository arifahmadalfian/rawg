package com.arifahmadalfian.rawgapp.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import com.arifahmadalfian.rawgapp.domain.model.dto.ResultsItemDto
import com.arifahmadalfian.rawgapp.domain.utils.DETAILS_GAME_ID
import com.arifahmadalfian.rawgapp.domain.utils.roundOneDecimal
import com.arifahmadalfian.rawgapp.navigation.BottomGraph
import timber.log.Timber

@ExperimentalCoilApi
@Composable
fun ListContent(
    resultItems: List<ResultsItemDto>?,
    navController: NavHostController,
    isLoading: Boolean,
    fromFavorite: Boolean = false,
    onLoadMore: () -> Unit = {},
) {
    val lazyListState = rememberLazyListState()

    val isItemWithKeyInView by remember {
        derivedStateOf {
            lazyListState.isScrollInProgress &&
                    lazyListState.layoutInfo
                        .visibleItemsInfo
                        .any { it.key == "key" }
        }
    }
    if (isItemWithKeyInView) {
        LaunchedEffect(Unit) {
            if (!isLoading) {
                onLoadMore()
                Timber.d("onLoadMore")
            }
        }
    }

    LazyColumn(
        state = lazyListState,
        contentPadding = PaddingValues(all = 8.dp),
        verticalArrangement = Arrangement.spacedBy(space = 4.dp)
    ) {
        resultItems?.let { results ->
            items (results) { result ->
                GameItem(result = result, navController = navController)
            }
            item {
                if (isLoading && results.isEmpty()) {
                    repeat(10) {
                        ListShimmer()
                    }
                }
            }
            item(key = "key") {
                if (!fromFavorite) ListShimmer()
            }
        } ?: kotlin.run {
            if (isLoading) {
                repeat(10) {
                    item {
                        ListShimmer()
                    }
                }
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
fun GameItem(
    result: ResultsItemDto,
    navController: NavHostController
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                navController.currentBackStackEntry?.savedStateHandle?.set(
                    key = DETAILS_GAME_ID,
                    value = result.id
                )
                navController.navigate(BottomGraph.DETAILS_ROUTE)
            }
            .padding(2.dp)
            .wrapContentHeight(),
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color.White
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            ImageLoading(
                modifier = Modifier
                    .width(120.dp)
                    .height(100.dp)
                    .clip(RoundedCornerShape(8.dp)),
                url = result.backgroundImage,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier
                        .heightIn(min = 48.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = result.name ?: "-",
                        style = MaterialTheme.typography.h6.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Release date ${result.released }",
                    style = MaterialTheme.typography.body2,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Row(
                    modifier = Modifier.padding(top = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RatingWidget(
                        modifier = Modifier.padding(end = 4.dp),
                        rating = result.rating.roundOneDecimal()
                    )
                    Text(
                        text = result.rating.roundOneDecimal().toString(),
                        style = MaterialTheme.typography.body2,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}
