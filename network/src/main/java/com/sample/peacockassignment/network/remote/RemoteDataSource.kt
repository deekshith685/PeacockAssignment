package com.sample.peacockassignment.network.remote

import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val networkService: NetworkService
) {
    suspend fun getLaunches() = networkService.getLaunches()
}
