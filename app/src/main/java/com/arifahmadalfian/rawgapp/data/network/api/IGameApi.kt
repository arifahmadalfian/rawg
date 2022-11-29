package com.arifahmadalfian.rawgapp.data.network.api

import com.arifahmadalfian.rawgapp.BuildConfig
import com.arifahmadalfian.rawgapp.domain.model.dto.GameDetailDto
import com.arifahmadalfian.rawgapp.domain.model.dto.GameDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IGameApi {

    @GET("/api/games")
    suspend fun getAllGame(
        @Query("page") page: Int = 1,
        @Query("page_size") pageSize: Int = 20,
        @Query("search") search: String? = null,
        @Query("key") key: String = BuildConfig.RAWG_KEY
    ): Response<GameDto>

    @GET("/api/games/{id}")
    suspend fun detailGame(
        @Path("id") id: Int,
        @Query("key") key: String = BuildConfig.RAWG_KEY
    ): Response<GameDetailDto>
}