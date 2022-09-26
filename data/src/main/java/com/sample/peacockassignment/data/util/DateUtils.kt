package com.sample.peacockassignment.data.util

import java.text.SimpleDateFormat
import java.util.*

object DateUtils {

    private const val DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ"
    private const val TARGET_DATE_TIME_FORMAT = "MM-dd-yyyy 'at' HH:mm:ssZ"

    fun convertDate(
        date: String,
        sourceDateFormat: String = DEFAULT_DATE_TIME_FORMAT,
        targetDateFormat: String = TARGET_DATE_TIME_FORMAT
    ): String {
        return try {
            val sourceFormatter = SimpleDateFormat(sourceDateFormat, Locale.getDefault())
            val targetFormatter = SimpleDateFormat(targetDateFormat, Locale.getDefault())
            val sourceDate = sourceFormatter.parse(date)
            sourceDate?.let {
                targetFormatter.format(it)
            } ?: date
        } catch (Ex: Exception) {
            date
        }
    }
}
