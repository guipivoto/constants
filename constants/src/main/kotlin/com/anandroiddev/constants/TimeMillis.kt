@file:Suppress("MemberVisibilityCanBePrivate", "unused")

package com.anandroiddev.constants

/**
 * Constants representing time in milliseconds.
 */
object TimeMillis {

    /**
     * The value of one second in milliseconds
     */
    const val SECOND: Long = 1000L

    /**
     * The value of one minute in milliseconds
     */
    const val MINUTE: Long = 60 * SECOND

    /**
     * The value of one minute in milliseconds
     */
    const val TEN_MINUTES: Long = 10 * MINUTE

    /**
     * The value of half of an hour in milliseconds
     */
    const val HALF_AN_HOUR: Long = 30 * MINUTE

    /**
     * The value of one hour in milliseconds
     */
    const val HOUR: Long = 60 * MINUTE

    /**
     * The value of half a day in milliseconds
     */
    const val HALF_A_DAY: Long = 12 * HOUR

    /**
     * The value of one day in milliseconds
     */
    const val DAY: Long = 24 * HOUR

    /**
     * The value of one week in milliseconds
     */
    const val WEEK: Long = 7 * DAY
}
