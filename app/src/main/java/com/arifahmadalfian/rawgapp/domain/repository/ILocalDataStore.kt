package com.arifahmadalfian.rawgapp.domain.repository

import com.arifahmadalfian.rawgapp.domain.model.entity.GameEntity
import kotlinx.coroutines.flow.Flow

interface ILocalDataStore {

    fun getAllGames(): Flow<List<GameEntity>>

    suspend fun addGameFavorite(game: GameEntity)

    suspend fun deleteGameFavorite(gameId: Int)

}

