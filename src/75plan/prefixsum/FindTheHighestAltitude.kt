package `75plan`.prefixsum

/**
 * There is a biker going on a road trip. The road trip consists of n + 1 points at different altitudes. The biker starts his trip on point 0 with altitude equal 0.
 * You are given an integer array gain of length n where gain[i] is the net gain in altitude between points
 * i and i + 1 for all (0 <= i < n). Return the highest altitude of a point.
 */
class FindTheHighestAltitude {
    // time O(n) / space O(1)
    fun largestAltitude(gain: IntArray): Int {
        var maxAlt = 0
        var currentAlt = 0

        gain.forEach {
            currentAlt += it
            maxAlt = maxAlt.coerceAtLeast(currentAlt)
        }
        return maxAlt
    }
}