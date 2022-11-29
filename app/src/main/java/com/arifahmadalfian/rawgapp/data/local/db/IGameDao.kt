package com.arifahmadalfian.rawgapp.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.arifahmadalfian.rawgapp.domain.model.entity.GameEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface IGameDao {

    @Query("SELECT * FROM game_table ORDER BY id ASC")
    fun getAllGames(): Flow<List<GameEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addGameFavorite(game: GameEntity)

    @Query("DELETE FROM game_table WHERE id=:gameId")
    suspend fun deleteGameFavorite(gameId: Int)

}