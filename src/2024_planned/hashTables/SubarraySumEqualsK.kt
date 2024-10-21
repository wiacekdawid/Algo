package `2024_planned`.hashTables

/**
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 * A subarray is a contiguous non-empty sequence of elements within an array.
 */

// time / space O(n) - prefix sum solution
class SubarraySumEqualsK {
    fun subarraySum(nums: IntArray, k: Int): Int {
        var currentSum = 0
        var result = 0
        val prefixSumMap = mutableMapOf(0 to 1)  // Map to store cumulative sums and their frequencies

        for (num in nums) {
            currentSum += num

            // Check if there is a prefix sum that, when subtracted from currentSum, equals k
            if (prefixSumMap.containsKey(currentSum - k)) {
                result += prefixSumMap[currentSum - k]!!
            }

            // Update the map with the current cumulative sum
            prefixSumMap[currentSum] = prefixSumMap.getOrDefault(currentSum, 0) + 1
        }

        return result
    }
}