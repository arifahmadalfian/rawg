package com.arifahmadalfian.rawgapp.domain.model.commons

import timber.log.Timber

sealed class ResourceState<T>(
    val data: T? = null,
    val message: String? = null,
    val code: Int? = null,
    val error: String? = null,
    val isEmpty: Boolean = false
) {
    class Success<T>(data: T?, code: Int?, message: String?) :
        ResourceState<T>(data = data, message = message, code = code)

    class Error<T>(data: T? = null, message: String?, code: Int?, error: String?) :
        ResourceState<T>(data = data, message = message, code = code, error = error)

    class Empty<T> : ResourceState<T>(isEmpty = true)

    class Idle<T> : ResourceState<T>()
}

fun <R> resourceInitialCopy(uiState: UiState<R>): UiState<R> {
    return uiState.copy(
        data = null, error = null, message = null, code = null, isLoading = true
    )
}

@Suppress("UNCHECKED_CAST")
fun <T, R> resourceViewModel(
    resourceState: ResourceState<T>, uiState: UiState<R>
): UiState<R> {
    return try {
        when (resourceState) {
            is ResourceState.Success -> {
                uiState.copy(
                    data = resourceState.data as R,
                    error = null,
                    message = resourceState.message,
                    code = resourceState.code,
                    isLoading = false,
                    isEmpty = false
                )
            }
            is ResourceState.Error -> {
                uiState.copy(
                    data = null,
                    error = resourceState.error,
                    message = resourceState.message,
                    code = resourceState.code,
                    isLoading = false
                )
            }
            is ResourceState.Empty -> {
                uiState.copy(
                    data = null,
                    error = null,
                    message = resourceState.message,
                    code = resourceState.code,
                    isLoading = false,
                    isEmpty = true
                )
            }
            is ResourceState.Idle -> {
                uiState.copy(
                    data = null, error = null, message = null, code = null, isLoading = false
                )
            }
        }
    } catch (e: Exception) {
        val exception = "${e.localizedMessage} -> ${resourceState.javaClass}"
        Timber.e(exception)

        uiState.copy(
            data = null, error = e.message, message = exception, isLoading = false
        )
    }
}
