package com.arifahmadalfian.rawgapp.domain.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.palette.graphics.Palette
import coil.ImageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.arifahmadalfian.rawgapp.RawgApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.withContext
import java.math.RoundingMode
import java.text.DecimalFormat


const val DETAILS_GAME_ID = "details_game_id"
const val FILLED_STARS = "filledStars"
const val HALF_FILLED_STARS = "halfFilledStars"
const val EMPTY_STARS = "emptyStars"


/**
 * extension function Check internet connection
 */
fun RawgApp.isInternetConnection(): Boolean {
    val connectivityManager = this.getSystemService(
        Context.CONNECTIVITY_SERVICE
    ) as ConnectivityManager
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        val activityNetwork = connectivityManager.activeNetwork ?: return false
        val capabilities =
            connectivityManager.getNetworkCapabilities(activityNetwork) ?: return false
        return when {
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    } else {
        @Suppress("DEPRECATION")
        connectivityManager.activeNetworkInfo?.run {
            return when (type) {
                ConnectivityManager.TYPE_WIFI -> true
                ConnectivityManager.TYPE_MOBILE -> true
                ConnectivityManager.TYPE_ETHERNET -> true
                else -> false
            }
        }
    }
    return false
}

/**
 * #.# format
 */
fun Double?.roundOneDecimal(): Double {
    return try {
        val df = DecimalFormat("#.#")
        df.roundingMode = RoundingMode.CEILING
        df.format(this).toDouble()
    } catch (e: NumberFormatException) {
        val df = DecimalFormat("#.#")
        df.roundingMode = RoundingMode.FLOOR
        return df.format(this ?: 0.0).toString().replace(",", ".").toDouble()
    }
    catch (e: Exception) {
        0.0
    }
}

fun Modifier.verticalGradientBackground(
    colors: List<Color>
) = gradientBackground(colors) { gradientColors, size ->
    Brush.verticalGradient(
        colors = gradientColors,
        startY = 0f,
        endY = size.width
    )
}

fun Modifier.gradientBackground(
    colors: List<Color>,
    brushProvider: (List<Color>, Size) -> Brush
): Modifier = composed {
    var size by remember { mutableStateOf(Size.Zero) }
    val gradient = remember(colors, size) { brushProvider(colors, size) }
    drawWithContent {
        size = this.size
        drawRect(brush = gradient)
        drawContent()
    }
}

