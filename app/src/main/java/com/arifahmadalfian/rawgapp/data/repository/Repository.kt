package com.arifahmadalfian.rawgapp.data.repository

import com.arifahmadalfian.rawgapp.domain.model.commons.ResourceState
import com.arifahmadalfian.rawgapp.domain.model.dto.GameDetailDto
import com.arifahmadalfian.rawgapp.domain.model.dto.GameDto
import com.arifahmadalfian.rawgapp.domain.model.entity.GameEntity
import com.arifahmadalfian.rawgapp.domain.repository.ILocalDataStore
import com.arifahmadalfian.rawgapp.domain.repository.IRemoteDataStore
import com.arifahmadalfian.rawgapp.domain.repository.IRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class Repository @Inject constructor(
    private val remoteDataSource: IRemoteDataStore,
    private val localDataSource: ILocalDataStore
): IRepository {

    override fun getAllGames(): Flow<List<GameEntity>> {
        return localDataSource.getAllGames()
    }

    override suspend fun addGameFavorite(game: GameEntity) {
        localDataSource.addGameFavorite(game)
    }

    override suspend fun deleteGameFavorite(gameId: Int) {
        localDataSource.deleteGameFavorite(gameId)
    }

    override suspend fun getAllGame(
        page: Int,
        pageSize: Int,
        search: String?
    ): ResourceState<GameDto> {
        return remoteDataSource.getAllGame(page, pageSize, search)
    }

    override suspend fun detailGame(id: Int): ResourceState<GameDetailDto> {
        return remoteDataSource.detailGame(id)
    }

}