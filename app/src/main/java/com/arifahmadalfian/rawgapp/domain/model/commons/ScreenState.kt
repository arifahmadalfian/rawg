package com.arifahmadalfian.rawgapp.domain.model.commons

import com.arifahmadalfian.rawgapp.domain.model.dto.ResultsItemDto

data class ScreenState(
    val isLoading: Boolean = false,
    val items: List<ResultsItemDto> = emptyList(),
    val error: String? = null,
    val endReached: Boolean = false,
    val page: Int = 1
)