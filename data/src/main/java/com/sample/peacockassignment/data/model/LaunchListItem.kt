package com.sample.peacockassignment.data.model

data class LaunchListItem(
    val missionName: String,
    val rocketName: String,
    val launchSiteName: String,
    val dateOfLaunch: String,
    val imageUrl: String?,
    var isSelected: Boolean = false
)
