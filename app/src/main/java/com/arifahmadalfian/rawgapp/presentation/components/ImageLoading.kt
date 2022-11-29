package com.arifahmadalfian.rawgapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.BlurEffect
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import coil.transform.RoundedCornersTransformation
import coil.transform.Transformation
import com.arifahmadalfian.rawgapp.R

@ExperimentalCoilApi
@Composable
fun ImageLoading(
    modifier: Modifier = Modifier,
    url: String? = null,
) {
    Box(
        modifier = modifier
    ) {
        val painter = rememberAsyncImagePainter(
            ImageRequest.Builder(LocalContext.current)
                .data(data = "$url").apply(block = fun ImageRequest.Builder.() {
                    crossfade(500)
                    placeholder(R.drawable.ic_placeholder)
                    error(R.drawable.ic_image_error)
                    transformations(
                        RoundedCornersTransformation(25f)
                    )
                    size(600, 600)
                }).build()
        )
        val painterState = painter.state
        Image(
            modifier = modifier,
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        if (painterState is AsyncImagePainter.State.Loading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .align(alignment = Alignment.Center),
                color = MaterialTheme.colors.secondary
            )
        }
    }
}

@ExperimentalCoilApi
@Composable
fun BackgroundImageBlur(
    url: String? = null,
) {
    val painter = rememberAsyncImagePainter(
        ImageRequest.Builder(LocalContext.current)
            .data(data = "$url").apply(block = fun ImageRequest.Builder.() {
                crossfade(500)
                placeholder(R.drawable.ic_placeholder)
                error(R.drawable.ic_image_error)
                transformations(
                    RoundedCornersTransformation(0f)
                )
                size(700, 700)
            }).build()
    )
    Image(
        modifier = Modifier
            .fillMaxSize()
            .graphicsLayer {
                renderEffect = BlurEffect(50f, 50f)
            },
        painter = painter,
        contentDescription = null,
        contentScale = ContentScale.Crop,
    )
}
