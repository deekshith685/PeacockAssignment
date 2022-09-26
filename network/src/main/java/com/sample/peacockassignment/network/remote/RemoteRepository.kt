package com.sample.peacockassignment.network.remote

import com.sample.peacockassignment.data.networkmodel.LaunchResponse
import com.sample.peacockassignment.network.model.BaseApiResponse
import com.sample.peacockassignment.network.utils.NetworkResult
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@ActivityRetainedScoped
class RemoteRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : BaseApiResponse() {
    fun getLaunches(): Flow<NetworkResult<List<LaunchResponse>>> {
        return flow {
            emit(safeApiCall { remoteDataSource.getLaunches() })
        }.flowOn(Dispatchers.IO)
    }
}
