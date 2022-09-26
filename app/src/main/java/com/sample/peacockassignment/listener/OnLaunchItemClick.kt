package com.sample.peacockassignment.listener

import com.sample.peacockassignment.data.networkmodel.LaunchResponse

interface OnLaunchItemClick {
    fun onItemClick(launchResponse: LaunchResponse, position: Int)
}