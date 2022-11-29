package com.arifahmadalfian.rawgapp.data.di

import com.arifahmadalfian.rawgapp.data.repository.Repository
import com.arifahmadalfian.rawgapp.domain.repository.ILocalDataStore
import com.arifahmadalfian.rawgapp.domain.repository.IRemoteDataStore
import com.arifahmadalfian.rawgapp.domain.repository.IRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(
        remoteDataStore: IRemoteDataStore,
        localDataStore: ILocalDataStore
    ): IRepository {
        return Repository(remoteDataStore, localDataStore)
    }
}