package com.arifahmadalfian.rawgapp.presentation.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arifahmadalfian.rawgapp.domain.utils.roundOneDecimal

@Composable
fun DetailsShimmer() {
    ItemShimmer {
        ShimmerLayout(it)
    }
}

@Composable
fun ListShimmer() {
    ItemShimmer {
        ShimmerGridItem(brush = it)
    }
}

@Composable
fun ItemShimmer( content:  @Composable (Brush)-> Unit) {
    val shimmerColors = listOf(
        Color.LightGray.copy(alpha = 0.6f),
        Color.LightGray.copy(alpha = 0.2f),
        Color.LightGray.copy(alpha = 0.6f),
    )

    val transition = rememberInfiniteTransition()
    val translateAnim = transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = FastOutLinearInEasing
            )
        )
    )

    val brush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset.Zero,
        end = Offset(x = translateAnim.value, y = translateAnim.value)
    )
    content(brush)
}

@Composable
fun ShimmerGridItem(brush: Brush) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)
            .wrapContentHeight(),
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color.White
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(
                modifier = Modifier
                    .width(120.dp)
                    .height(100.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(brush)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column(verticalArrangement = Arrangement.Center) {
                Spacer(
                    modifier = Modifier
                        .height(32.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .fillMaxWidth()
                        .background(brush)
                )
                Spacer(modifier = Modifier.padding(5.dp))
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .fillMaxWidth(fraction = 0.7f)
                        .background(brush)
                )
                Row(
                    modifier = Modifier.padding(top = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(
                        modifier = Modifier
                            .height(20.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .fillMaxWidth(fraction = 0.5f)
                            .background(brush)
                    )
                    Spacer(modifier = Modifier.padding(2.dp))
                    Spacer(
                        modifier = Modifier
                            .height(20.dp)
                            .width(20.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(brush)
                    )
                }
            }
        }
    }
}

@Composable
fun ShimmerLayout(brush: Brush) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(2.dp),
        elevation = 4.dp,
        backgroundColor = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(brush)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Column(verticalArrangement = Arrangement.Center) {
                Spacer(
                    modifier = Modifier
                        .height(32.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .fillMaxWidth()
                        .background(brush)
                )
                Spacer(modifier = Modifier.padding(5.dp))
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .fillMaxWidth(fraction = 0.7f)
                        .background(brush)
                )
                Row(
                    modifier = Modifier.padding(top = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(
                        modifier = Modifier
                            .height(20.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .fillMaxWidth(fraction = 0.5f)
                            .background(brush)
                    )
                    Spacer(modifier = Modifier.padding(2.dp))
                    Spacer(
                        modifier = Modifier
                            .height(20.dp)
                            .width(20.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(brush)
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ShimmerGridItemPreview() {
    ListShimmer()
}

@Composable
@Preview(showBackground = true)
fun ShimmerLayoutItemPreview() {
    DetailsShimmer()
}
