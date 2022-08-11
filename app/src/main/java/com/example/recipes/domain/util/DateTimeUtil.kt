package com.example.recipes.domain.util

import kotlinx.datetime.*

class DateTimeUtil {

    fun now(): LocalDateTime{
        val currentMoment: Instant = Clock.System.now()
        return currentMoment.toLocalDateTime(TimeZone.UTC)
    }

    fun toLocalDate(date: Double): LocalDateTime{
        return  Instant.fromEpochMilliseconds(date.toLong()).toLocalDateTime(TimeZone.UTC)
    }

    fun toEpochMilliseconds(date: LocalDateTime): Double{
        return date.toInstant(TimeZone.UTC).toEpochMilliseconds().toDouble()
    }


}