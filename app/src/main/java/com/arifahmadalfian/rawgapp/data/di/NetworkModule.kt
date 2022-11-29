package com.arifahmadalfian.rawgapp.data.di

import android.app.Application
import com.arifahmadalfian.rawgapp.BuildConfig
import com.arifahmadalfian.rawgapp.data.network.api.IGameApi
import com.arifahmadalfian.rawgapp.data.network.RemoteDataStore
import com.arifahmadalfian.rawgapp.domain.repository.IRemoteDataStore
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@ExperimentalSerializationApi
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofitInstance(
        okHttpClient: OkHttpClient
    ): Retrofit {
        val contentType = "application/json".toMediaType()
        val json = Json {
            ignoreUnknownKeys = true
            isLenient = true
        }
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()
    }

    @Provides
    @Singleton
    fun provideGameApi(
        retrofit: Retrofit
    ): IGameApi {
        return retrofit.create(IGameApi::class.java)
    }

    @Provides
    @Singleton
    fun provideGameRepository(
        gameApi: IGameApi,
        application: Application
    ): IRemoteDataStore {
        return RemoteDataStore(gameApi, application)
    }

}