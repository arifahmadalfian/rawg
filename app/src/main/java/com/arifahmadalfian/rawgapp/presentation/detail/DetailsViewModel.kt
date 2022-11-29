package com.arifahmadalfian.rawgapp.presentation.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arifahmadalfian.rawgapp.domain.model.commons.UiState
import com.arifahmadalfian.rawgapp.domain.model.commons.resourceInitialCopy
import com.arifahmadalfian.rawgapp.domain.model.commons.resourceViewModel
import com.arifahmadalfian.rawgapp.domain.model.dto.GameDetailDto
import com.arifahmadalfian.rawgapp.domain.model.entity.GameEntity
import com.arifahmadalfian.rawgapp.domain.repository.IRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val repository: IRepository
) : ViewModel() {

    var gameDetail by mutableStateOf(UiState<GameDetailDto>())
        private set

    val favoriteGames: Flow<List<GameEntity>> = repository.getAllGames()

    fun detailGame(id: Int) {
        gameDetail = resourceInitialCopy(gameDetail)
        viewModelScope.launch {
            repository.detailGame(id).also {
                gameDetail = resourceViewModel(it, gameDetail)
            }
        }
    }

    fun addGameFavorite(game: GameEntity) {
        viewModelScope.launch {
            repository.addGameFavorite(game)
        }
    }

    fun deleteGameFavorite(gameId: Int) {
        viewModelScope.launch {
            repository.deleteGameFavorite(gameId)
        }
    }

}