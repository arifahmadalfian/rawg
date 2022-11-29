package com.arifahmadalfian.rawgapp.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arifahmadalfian.rawgapp.domain.model.commons.Paginate
import com.arifahmadalfian.rawgapp.domain.model.commons.ScreenState
import com.arifahmadalfian.rawgapp.domain.model.dto.ResultsItemDto
import com.arifahmadalfian.rawgapp.domain.repository.IRemoteDataStore
import com.arifahmadalfian.rawgapp.domain.repository.IRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: IRepository
) : ViewModel() {

    var gameState by mutableStateOf(ScreenState())
    var searchGame: String? by mutableStateOf(null)

    @Suppress("UNCHECKED_CAST")
    private val paginator = Paginate(
        initialKey = gameState.page,
        onLoadUpdated = {
            gameState = gameState.copy(isLoading = it)
        },
        onRequest = { nextPage ->
            repository.getAllGame(nextPage, 15, searchGame)
        },
        getNextKey = {
            gameState.page + 1
        },
        onError = {
            gameState = gameState.copy(error = it)
        },
        onSuccess = { items, newKey ->
            gameState = gameState.copy(
                items = gameState.items + (items.results as List<ResultsItemDto>),
                page = newKey,
                endReached = items.results.isEmpty()
            )
        }
    )

    init {
        loadNextItems()
    }

    fun loadNextItems() {
        viewModelScope.launch {
            paginator.loadNextItems()
        }
    }

    fun reset() {
        gameState = ScreenState()
        paginator.reset()
    }
}
