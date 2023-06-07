package `75plan`.slidingwindow

/**
 * You are given an integer array nums consisting of n elements, and an integer k.
 * Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.
 */
class MaximumAverageSubarrayI {
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        if (nums.size < k) return 0.0

        val currentArray = IntArray(size = k) { Integer.MIN_VALUE }
        var currentMin = Integer.MAX_VALUE

        nums.forEachIndexed { index, i ->
            if (i < k) {
                currentArray[index] = i
                currentMin = i.coerceAtMost(currentMin)
            } else {
                if (i )
            }

        }
    }
}