package `2024_planned`.hashTables

import kotlin.math.abs

/**
 * Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 */
// time / space O(n)
class ContainsDuplicateII {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val mapOfIndex = mutableMapOf<Int, Int>()
        for (currentIndex in nums.indices) {
            val num = nums[currentIndex]
            if (mapOfIndex.containsKey(num)) {
                val savedIndex = mapOfIndex[num]!!
                if (abs(savedIndex - currentIndex) <= k) {
                    return true
                }
            }
            mapOfIndex[num] = currentIndex
        }
        return false
    }
}