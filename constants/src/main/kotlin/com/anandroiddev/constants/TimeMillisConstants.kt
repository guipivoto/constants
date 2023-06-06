@file:Suppress("MemberVisibilityCanBePrivate", "unused")

package com.anandroiddev.constants

/**
 * Constants representing time in milliseconds.
 */
object TimeMillisConstants {

    /**
     * The value of one second in milliseconds
     */
    const val ONE_SECOND: Long = 1000L

    /**
     * The value of one minute in milliseconds
     */
    const val ONE_MINUTE: Long = 60 * ONE_SECOND

    /**
     * The value of one minute in milliseconds
     */
    const val TEN_MINUTES: Long = 10 * ONE_MINUTE

    /**
     * The value of half of an hour in milliseconds
     */
    const val HALF_AN_HOUR: Long = 30 * ONE_MINUTE

    /**
     * The value of one hour in milliseconds
     */
    const val ONE_HOUR: Long = 60 * ONE_MINUTE

    /**
     * The value of half a day in milliseconds
     */
    const val HALF_A_DAY: Long = 12 * ONE_HOUR

    /**
     * The value of one day in milliseconds
     */
    const val ONE_DAY: Long = 24 * ONE_HOUR

    /**
     * The value of one week in milliseconds
     */
    const val ONE_WEEK: Long = 7 * ONE_DAY
}
