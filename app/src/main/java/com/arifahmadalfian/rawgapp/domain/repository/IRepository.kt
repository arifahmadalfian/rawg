package com.arifahmadalfian.rawgapp.domain.repository

import com.arifahmadalfian.rawgapp.domain.model.commons.ResourceState
import com.arifahmadalfian.rawgapp.domain.model.dto.GameDetailDto
import com.arifahmadalfian.rawgapp.domain.model.dto.GameDto
import com.arifahmadalfian.rawgapp.domain.model.entity.GameEntity
import kotlinx.coroutines.flow.Flow

interface IRepository {

    fun getAllGames(): Flow<List<GameEntity>>

    suspend fun addGameFavorite(game: GameEntity)

    suspend fun deleteGameFavorite(gameId: Int)

    suspend fun getAllGame(
        page: Int,
        pageSize: Int,
        search: String? = null
    ): ResourceState<GameDto>

    suspend fun detailGame(
        id: Int,
    ): ResourceState<GameDetailDto>
}