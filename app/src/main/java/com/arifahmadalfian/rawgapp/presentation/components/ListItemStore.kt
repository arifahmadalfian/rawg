package com.arifahmadalfian.rawgapp.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.arifahmadalfian.rawgapp.domain.model.dto.PlatformsItemDto
import com.arifahmadalfian.rawgapp.domain.model.dto.StoreDto
import com.arifahmadalfian.rawgapp.domain.model.dto.StoresItemDto

@Composable
fun ListItemStore(store: StoresItemDto) {
    Row {
        Icon(
            imageVector = Icons.Default.ArrowForward,
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = store.store?.name ?: "-",
            color = Color.Black.copy(alpha = ContentAlpha.medium),
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier.padding(4.dp)
        )
    }
}