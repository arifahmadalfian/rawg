package com.arifahmadalfian.rawgapp.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.arifahmadalfian.rawgapp.domain.model.entity.GameEntity

@Database(
    entities = [
        GameEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(DatabaseConverter::class)
abstract class GameDatabase : RoomDatabase() {

    abstract fun gameDao(): IGameDao

}