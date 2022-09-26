package com.sample.peacockassignment.ui.fragment.detailsfragment

import android.app.Application
import com.sample.peacockassignment.network.remote.RemoteRepository
import com.sample.peacockassignment.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    networkRepository: RemoteRepository,
    application: Application
) : BaseViewModel(networkRepository, application)
