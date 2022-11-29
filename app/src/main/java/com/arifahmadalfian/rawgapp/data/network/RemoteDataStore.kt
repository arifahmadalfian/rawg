package com.arifahmadalfian.rawgapp.data.network

import android.app.Application
import com.arifahmadalfian.rawgapp.R
import com.arifahmadalfian.rawgapp.RawgApp
import com.arifahmadalfian.rawgapp.data.network.api.IGameApi
import com.arifahmadalfian.rawgapp.domain.model.commons.ResourceState
import com.arifahmadalfian.rawgapp.domain.model.dto.GameDetailDto
import com.arifahmadalfian.rawgapp.domain.model.dto.GameDto
import com.arifahmadalfian.rawgapp.domain.repository.IRemoteDataStore
import com.arifahmadalfian.rawgapp.domain.utils.isInternetConnection
import dagger.hilt.android.internal.Contexts.getApplication
import dagger.hilt.android.scopes.ViewModelScoped
import timber.log.Timber
import java.net.SocketTimeoutException
import javax.inject.Inject

@ViewModelScoped
class RemoteDataStore @Inject constructor(
    private val apiGame: IGameApi,
    private val application: Application,
) : IRemoteDataStore {
    override suspend fun getAllGame(
        page: Int,
        pageSize: Int,
        search: String?
    ): ResourceState<GameDto> {
        return try {
            ResourceState.Idle<GameDto>()
            if ((getApplication(application) as RawgApp).isInternetConnection()) {
                apiGame.getAllGame(page, pageSize, search).let {
                    if (it.isSuccessful) {
                        ResourceState.Success(
                            data = it.body(),
                            message = application.applicationContext.getString(R.string.success),
                            code = 200
                        )
                    } else {
                        ResourceState.Error(
                            message = application.applicationContext.getString(R.string.error),
                            code = 400,
                            error = application.applicationContext.getString(R.string.error)
                        )
                    }
                }
            } else {
                ResourceState.Error(
                    message = application.applicationContext.getString(R.string.no_internet_connection),
                    code = 100,
                    error = application.applicationContext.getString(R.string.no_internet_connection)
                )
            }
        } catch (s: SocketTimeoutException) {
            ResourceState.Error(
                message = application.applicationContext.getString(R.string.internet_connection_timeout),
                code = 500,
                error = s.message.toString()
            )
        } catch (e: Exception) {
            Timber.e(e.localizedMessage)
            ResourceState.Error(
                message = e.localizedMessage
                    ?: application.applicationContext.getString(R.string.error),
                code = 500,
                error = e.localizedMessage
                    ?: application.applicationContext.getString(R.string.error)
            )
        }
    }

    override suspend fun detailGame(id: Int): ResourceState<GameDetailDto> {
        return try {
            ResourceState.Idle<GameDto>()
            if ((getApplication(application) as RawgApp).isInternetConnection()) {
                apiGame.detailGame(id).let {
                    if (it.isSuccessful) {
                        ResourceState.Success(
                            data = it.body(),
                            message = application.applicationContext.getString(R.string.success),
                            code = 200
                        )
                    } else {
                        ResourceState.Error(
                            message = application.applicationContext.getString(R.string.error),
                            code = 400,
                            error = application.applicationContext.getString(R.string.error)
                        )
                    }
                }
            } else {
                ResourceState.Error(
                    message = application.applicationContext.getString(R.string.no_internet_connection),
                    code = 100,
                    error = application.applicationContext.getString(R.string.no_internet_connection)
                )
            }
        } catch (s: SocketTimeoutException) {
            ResourceState.Error(
                message = application.applicationContext.getString(R.string.internet_connection_timeout),
                code = 500,
                error = s.message.toString()
            )
        } catch (e: Exception) {
            Timber.e(e.localizedMessage)
            ResourceState.Error(
                message = e.localizedMessage
                    ?: application.applicationContext.getString(R.string.error),
                code = 500,
                error = e.localizedMessage
                    ?: application.applicationContext.getString(R.string.error)
            )
        }
    }

}