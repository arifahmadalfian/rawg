package com.arifahmadalfian.rawgapp.data.di

import android.content.Context
import androidx.room.Room
import com.arifahmadalfian.rawgapp.data.local.db.GameDatabase
import com.arifahmadalfian.rawgapp.data.local.LocalDataStore
import com.arifahmadalfian.rawgapp.domain.repository.ILocalDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): GameDatabase = Room.databaseBuilder(
        context,
        GameDatabase::class.java,
        "game_database"
    ).build()

    @Provides
    @Singleton
    fun provideLocalDataSource(
        gameDatabase: GameDatabase
    ): ILocalDataStore {
        return LocalDataStore(gameDatabase = gameDatabase)
    }
}