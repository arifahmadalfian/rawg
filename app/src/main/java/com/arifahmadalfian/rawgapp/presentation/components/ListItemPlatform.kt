package com.arifahmadalfian.rawgapp.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.arifahmadalfian.rawgapp.domain.model.dto.PlatformsItemDto

@Composable
fun ListItemPlatform(platform: PlatformsItemDto) {
    Column {
        Row {
            Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = platform.platform?.name ?: "-",
                color = Color.Black.copy(alpha = ContentAlpha.medium),
                style = MaterialTheme.typography.subtitle2,
                modifier = Modifier.padding(4.dp)
            )
        }
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = "Released: ${platform.releasedAt ?: "-"}",
            color = Color.Black.copy(alpha = ContentAlpha.medium),
            style = MaterialTheme.typography.subtitle2,
        )

        platform.requirements?.minimum?.let {
            Text(
                modifier = Modifier.padding(start = 16.dp),
                text = "Requirements: $it",
                color = Color.Black.copy(alpha = ContentAlpha.medium),
                style = MaterialTheme.typography.subtitle2,
            )
        }
    }
}