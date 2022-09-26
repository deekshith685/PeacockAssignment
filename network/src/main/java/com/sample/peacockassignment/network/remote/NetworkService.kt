package com.sample.peacockassignment.network.remote

import com.sample.peacockassignment.data.networkmodel.LaunchResponse
import com.sample.peacockassignment.network.utils.Constants
import retrofit2.Response
import retrofit2.http.GET

interface NetworkService {

    @GET(Constants.LAUNCHES)
    suspend fun getLaunches(): Response<List<LaunchResponse>>
}
