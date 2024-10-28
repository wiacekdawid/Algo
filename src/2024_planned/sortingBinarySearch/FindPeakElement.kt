package `2024_planned`.sortingBinarySearch

/**
 * A peak element is an element that is strictly greater than its neighbors.
 * Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks,
 * return the index to any of the peaks.
 * You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered
 * to be strictly greater than a neighbor that is outside the array.
 * You must write an algorithm that runs in O(log n) time.
 */

// time O(logN) / space O(1)
class FindPeakElement {
    fun findPeakElement(nums: IntArray): Int {
        var left = 0
        var right = nums.size-1

        while (left < right) {
            val mid = (left + right) / 2

            // If mid element is smaller than the next one, move to the right half
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1
            }
            // Otherwise, move to the left half
            else {
                right = mid
            }
        }

        // At the end of the loop, left and right converge to the peak index
        return left
    }
}