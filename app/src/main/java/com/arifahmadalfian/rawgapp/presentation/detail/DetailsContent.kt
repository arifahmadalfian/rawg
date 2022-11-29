package com.arifahmadalfian.rawgapp.presentation.detail

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import com.arifahmadalfian.rawgapp.R
import com.arifahmadalfian.rawgapp.domain.model.dto.GameDetailDto
import com.arifahmadalfian.rawgapp.domain.utils.roundOneDecimal
import com.arifahmadalfian.rawgapp.presentation.components.*
import com.arifahmadalfian.rawgapp.presentation.ui.theme.topAppBarContentColor

@ExperimentalCoilApi
@Composable
fun BoxTopSection(gameDetail: GameDetailDto?, scrollState: ScrollState) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(450.dp)
    ) {

        BackgroundImageBlur(
            url = gameDetail?.backgroundImage
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(
                modifier = Modifier
                    .height(56.dp)
                    .fillMaxWidth()
            )
            val dynamicValue =
                if (250.dp - Dp(scrollState.value / 50f) < 10.dp) 10.dp
                else 250.dp - Dp(scrollState.value / 20f)
            val animateImageSize = animateDpAsState(dynamicValue).value
            ImageLoading(
                url = gameDetail?.backgroundImage,
                modifier = Modifier
                    .size(animateImageSize)
                    .padding(8.dp)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxHeight(0.3f)
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(Color.Black.copy(ContentAlpha.medium)),
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(all = 16.dp)
                ) {
                    gameDetail?.genres?.let {
                        if (it.isNotEmpty()) {
                            Text(
                                text = it[0].name ?: "-",
                                color = Color.White.copy(alpha = ContentAlpha.medium),
                                fontSize = typography.subtitle1.fontSize,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }

                    Text(
                        text = gameDetail?.name ?: "-",
                        color = MaterialTheme.colors.topAppBarContentColor,
                        fontSize = typography.h5.fontSize,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Released: ${gameDetail?.released ?: "-"}",
                            color = Color.White.copy(alpha = ContentAlpha.medium),
                            fontSize = typography.subtitle1.fontSize,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(
                            modifier = Modifier
                                .size(18.dp),
                            painter = painterResource(id = R.drawable.ic_game_controller),
                            tint = Color.White.copy(alpha = ContentAlpha.medium),
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "${gameDetail?.playtime ?: "-"} Played",
                            color = Color.White.copy(alpha = ContentAlpha.medium),
                            fontSize = typography.subtitle1.fontSize,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }

                    Row(
                        modifier = Modifier.padding(top = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RatingWidget(
                            modifier = Modifier.padding(end = 4.dp),
                            rating = gameDetail?.rating.roundOneDecimal()
                        )
                        Text(
                            text = gameDetail?.rating.roundOneDecimal().toString(),
                            style = typography.body2,
                            color = Color.White.copy(alpha = ContentAlpha.medium),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun BottomScrollableContent(
    gameDetail: GameDetailDto?,
    scrollState: ScrollState
) {
    Column(modifier = Modifier.verticalScroll(state = scrollState)) {
        Spacer(modifier = Modifier.height(450.dp))
        Column(modifier = Modifier.background(Color.White)) {
            GameDescriptionScrollingSection(gameDetail = gameDetail)
        }
    }
}

@Composable
fun GameDescriptionScrollingSection(gameDetail: GameDetailDto?) {
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        ContentDescription(title = "Description") {
            Text(
                text = gameDetail?.descriptionRaw ?: "-",
                color = Color.Black.copy(alpha = ContentAlpha.medium),
                style = typography.subtitle2,
                modifier = Modifier.padding(4.dp)
            )
        }

        Spacer(
            modifier = Modifier
                .padding(top = 4.dp, bottom = 4.dp)
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.Black.copy(alpha = 0.3f))
        )

        ContentDescription(title = "Platforms") {
            gameDetail?.platforms?.let {
                if (it.isNotEmpty()) {
                    Column {
                        it.forEach { platform ->
                            ListItemPlatform(platform = platform)
                        }
                    }
                }
            }
        }

        Spacer(
            modifier = Modifier
                .padding(top = 4.dp, bottom = 4.dp)
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.Black.copy(alpha = 0.3f))
        )

        ContentDescription(title = "Stores") {
            gameDetail?.stores?.let {
                if (it.isNotEmpty()) {
                    Column {
                        it.forEach { store ->
                            ListItemStore(store = store)
                        }
                    }
                }
            }
        }

        Spacer(
            modifier = Modifier
                .padding(top = 4.dp, bottom = 4.dp)
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.Black.copy(alpha = 0.3f))
        )

        ContentDescription(title = "Developer") {
            gameDetail?.developers?.let {
                if (it.isNotEmpty()) {
                    Column {
                        it.forEach { developer ->
                            ListItemDeveloper(developer = developer)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ContentDescription(title: String, content: @Composable () -> Unit) {
    Text(
        modifier = Modifier.padding(4.dp),
        text = title,
        fontWeight = FontWeight.Bold,
        fontSize = typography.subtitle1.fontSize,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
    content()
}

@Composable
fun AnimatedToolBar(
    gameDetail: GameDetailDto?,
    scrollState: ScrollState,
    isFavorite: Boolean,
    onFavoriteClicked: (Boolean) -> Unit,
    onBack: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(
                if (Dp(scrollState.value.toFloat()) < 1080.dp)
                    Color.Transparent
                else
                    MaterialTheme.colors.primary
            )
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        IconButton(
            modifier = Modifier
                .clip(CircleShape)
                .background(
                    if (Dp(scrollState.value.toFloat()) < 1080.dp) Color.Gray.copy(alpha = 0.3f) else Color.Transparent
                ),
            onClick = {
                onBack()
            }
        ) {
            Icon(
                modifier = Modifier
                    .padding(2.dp),
                imageVector = Icons.Default.ArrowBack,
                tint = if (Dp(scrollState.value.toFloat()) < 1080.dp) Color.Black else Color.White,
                contentDescription = null
            )
        }
        Text(
            text = gameDetail?.name ?: "-",
            fontWeight = FontWeight.Bold,
            color = if (Dp(scrollState.value.toFloat()) < 1080.dp) Color.Black else Color.White,
            modifier = Modifier
                .padding(16.dp)
                .weight(1f)
                .alpha(((scrollState.value + 0.4f) / 1000).coerceIn(0f, 1f))
        )

        var favorite by remember {
            mutableStateOf(isFavorite)
        }

        IconButton(
            modifier = Modifier
                .clip(CircleShape)
                .background(
                    if (Dp(scrollState.value.toFloat()) < 1080.dp) Color.Gray.copy(alpha = 0.3f) else Color.Transparent
                ),
            onClick = {
                if (gameDetail != null) {
                    favorite = !favorite
                    onFavoriteClicked(favorite)
                }
            }
        ) {
            Icon(
                modifier = Modifier
                    .padding(2.dp),
                imageVector = Icons.Default.Favorite,
                tint = if (favorite) Color.Red else Color.White,
                contentDescription = null
            )
        }
    }
}