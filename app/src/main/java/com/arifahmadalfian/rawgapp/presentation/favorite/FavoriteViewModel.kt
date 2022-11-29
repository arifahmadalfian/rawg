package com.arifahmadalfian.rawgapp.presentation.favorite

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.arifahmadalfian.rawgapp.domain.model.entity.GameEntity
import com.arifahmadalfian.rawgapp.domain.repository.IRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val repository: IRepository
) : ViewModel() {

    val emptyState = mutableStateOf(false)

    val favoriteGames: Flow<List<GameEntity>> = repository.getAllGames()
        .onEach { games ->
            emptyState.value = games.isEmpty()
        }

}