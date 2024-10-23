package `2024_planned`.sortingBinarySearch

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 */

// time O(nlogn) / space O(n)
class MergeIntervals {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if (intervals.isEmpty()) return emptyArray()

        // Sort intervals based on the starting values
        intervals.sortBy { it[0] }

        val output = mutableListOf<IntArray>()
        var startIndex = intervals.first()[0]
        var endIndex = intervals.first()[1]

        intervals.forEach { interval ->
            if (interval[0] <= endIndex) {
                // Merge intervals by updating the end index to the max of both intervals
                endIndex = maxOf(endIndex, interval[1])
            } else {
                // Add the previous merged interval to the output
                output.add(intArrayOf(startIndex, endIndex))
                // Update startIndex and endIndex to the current interval
                startIndex = interval[0]
                endIndex = interval[1]
            }
        }

        // Add the last interval to the output
        output.add(intArrayOf(startIndex, endIndex))

        return output.toTypedArray()
    }
}