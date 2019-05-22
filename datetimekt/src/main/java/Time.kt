import Consts.SECONDS_IN_A_MINUTE
import Consts.SECONDS_IN_AN_HOUR
import Consts.SECONDS_IN_A_DAY

class Time private constructor(
    private var h: Int,
    private var m: Int,
    private var s: Int
){

    fun getHours(): Int = h
    fun getMinutes(): Int = m
    fun getSeconds(): Int = s

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Time
        if (h != other.h) return false
        if (m != other.m) return false
        if (s != other.s) return false
        return true
    }

    override fun hashCode(): Int {
        var result = h
        result = 31 * result + m
        result = 31 * result + s
        return result
    }

    override fun toString(): String {
        return String.format("%02d:%02d:%02d", h, m, s)
    }

    companion object {

        /**
         * Produces a new Time.
         *
         * Times of 24 hours or greater and negative times
         * will wrap around 24 hours to always produce a positive time.
         *
         * The value is calculated from total number of seconds so a time
         * with a minute value of 90 would add an hour to the resulting time
         * and set the minutes to 30, for example.
         */
        @JvmStatic
        fun new(h: Int, m: Int, s: Int): Time {
            val totalSeconds = s + SECONDS_IN_A_MINUTE * m + SECONDS_IN_AN_HOUR * h
            return fromSeconds(totalSeconds)
        }

        /**
        * Same as `TimeTuple::new()` but takes the total number of seconds
        * as its argument and calculates the hours, minutes, and seconds
        * from that.
        */
        @JvmStatic
        @Suppress("MemberVisibilityCanBePrivate")
        fun fromSeconds(totalSeconds: Int): Time {
            var s = totalSeconds
            while (s < 0) s += SECONDS_IN_A_DAY
            while (s >= SECONDS_IN_A_DAY) s -= SECONDS_IN_A_DAY
            val h = s / SECONDS_IN_AN_HOUR
            s -= h * SECONDS_IN_AN_HOUR
            val m = s / SECONDS_IN_A_MINUTE
            s -= m * SECONDS_IN_A_MINUTE
            return Time(h, m, s)
        }

    }

}