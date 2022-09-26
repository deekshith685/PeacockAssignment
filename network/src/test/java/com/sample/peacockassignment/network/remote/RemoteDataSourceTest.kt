package com.sample.peacockassignment.network.remote

import com.nhaarman.mockitokotlin2.mock
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

@ExperimentalCoroutinesApi
class RemoteDataSourceTest {

    private val mockNetworkService: NetworkService = mock()
    private lateinit var remoteDataSource: RemoteDataSource

    @Before
    fun setUp() {
        remoteDataSource = RemoteDataSource(mockNetworkService)
    }

    @Test
    fun `test getLaunches should call getLaunches function from service`() = runBlockingTest {
        remoteDataSource.getLaunches()
        Mockito.verify(mockNetworkService).getLaunches()
    }
}