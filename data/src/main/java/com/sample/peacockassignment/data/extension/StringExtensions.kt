package com.sample.peacockassignment.data.extension

fun String?.orDefaultPlaceHolder(placeholder: String = "--") =
    this.takeIf { it?.isNotBlank() == true } ?: placeholder
