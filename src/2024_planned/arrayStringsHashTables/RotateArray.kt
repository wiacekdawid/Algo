package `2024_planned`.arrayStringsHashTables

import kotlin.math.abs

/**
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 */

// time O(n) / space O(1)
class RotateArray {
    fun rotate(nums: IntArray, k: Int): Unit {
        if (nums.isEmpty()) return
        val effectiveK = k % nums.size
        var startIndex = 0
        var endIndex = nums.size-1
        while (startIndex < endIndex) {
            val cache = nums[startIndex]
            nums[startIndex++] = nums[endIndex]
            nums[endIndex--] = cache
        }

        startIndex = 0
        endIndex = effectiveK-1

        while (startIndex < endIndex) {
            val cache = nums[startIndex]
            nums[startIndex++] = nums[endIndex]
            nums[endIndex--] = cache
        }

        startIndex = effectiveK
        endIndex = nums.size-1

        while (startIndex < endIndex) {
            val cache = nums[startIndex]
            nums[startIndex++] = nums[endIndex]
            nums[endIndex--] = cache
        }
    }
}