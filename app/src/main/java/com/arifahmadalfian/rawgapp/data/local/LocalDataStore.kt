package com.arifahmadalfian.rawgapp.data.local

import com.arifahmadalfian.rawgapp.data.local.db.GameDatabase
import com.arifahmadalfian.rawgapp.data.local.db.IGameDao
import com.arifahmadalfian.rawgapp.domain.model.entity.GameEntity
import com.arifahmadalfian.rawgapp.domain.repository.ILocalDataStore
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class LocalDataStore@Inject constructor(
    gameDatabase: GameDatabase
): ILocalDataStore {

    private val gameDao: IGameDao = gameDatabase.gameDao()

    override fun getAllGames(): Flow<List<GameEntity>> {
        return gameDao.getAllGames()
    }

    override suspend fun addGameFavorite(game: GameEntity) {
        gameDao.addGameFavorite(game)
    }

    override suspend fun deleteGameFavorite(gameId: Int) {
        gameDao.deleteGameFavorite(gameId)
    }
}