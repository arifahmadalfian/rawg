package com.arifahmadalfian.rawgapp.domain.repository

import com.arifahmadalfian.rawgapp.domain.model.commons.ResourceState
import com.arifahmadalfian.rawgapp.domain.model.dto.GameDetailDto
import com.arifahmadalfian.rawgapp.domain.model.dto.GameDto
import retrofit2.Response

interface IRemoteDataStore {

    suspend fun getAllGame(
        page: Int,
        pageSize: Int,
        search: String? = null
    ): ResourceState<GameDto>

    suspend fun detailGame(
        id: Int,
    ): ResourceState<GameDetailDto>

}