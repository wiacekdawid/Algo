package `2024_planned`.sortingBinarySearch

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 */

// time O(log(min(m, n))) / space O(1)
class MedianOfTwoSortedArrays {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        // Ensure the smaller array is the one we use binary search on
        if (nums1.size > nums2.size) return findMedianSortedArrays(nums2, nums1)

        val m = nums1.size
        val n = nums2.size
        var left = 0
        var right = m

        while (left <= right) {
            // Guess a split point in nums1
            val partition1 = left + (right - left) / 2
            // Calculate a corresponding split point in nums2
            val partition2 = (m + n + 1) / 2 - partition1

            // Get the maximum and minimum elements around the partitions
            val maxLeft1 = if (partition1 == 0) Int.MIN_VALUE else nums1[partition1 - 1]
            val minRight1 = if (partition1 == m) Int.MAX_VALUE else nums1[partition1]

            val maxLeft2 = if (partition2 == 0) Int.MIN_VALUE else nums2[partition2 - 1]
            val minRight2 = if (partition2 == n) Int.MAX_VALUE else nums2[partition2]

            // Check if we found the correct partition
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // If total length is even, median is the average of two middle elements
                if ((m + n) % 2 == 0) {
                    return (maxOf(maxLeft1, maxLeft2) + minOf(minRight1, minRight2)) / 2.0
                } else {
                    // If total length is odd, median is the middle element on the left side
                    return maxOf(maxLeft1, maxLeft2).toDouble()
                }
            } else if (maxLeft1 > minRight2) {
                // Move search space to the left
                right = partition1 - 1
            } else {
                // Move search space to the right
                left = partition1 + 1
            }
        }

        // If no solution is found, throw an error (shouldn't happen with valid input)
        throw IllegalArgumentException("Input arrays are not sorted or have an invalid length")
    }
}