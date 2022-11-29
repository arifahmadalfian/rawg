package com.arifahmadalfian.rawgapp.domain.model.commons

data class UiState<T>(
    val data: T? = null,
    val error: String? = null,
    val message: String? = null,
    val code: Int? = null,
    val isLoading: Boolean = false,
    val isEmpty: Boolean = false,
)
