package sortingandsearch

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 * explanation: https://www.youtube.com/watch?v=LPFhl65R7ww
 */

class MedianOfTwoSortedArrays {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val num1Size: Int = nums1.size
        val num2Size: Int = nums2.size
        if (num1Size > num2Size) { // to ensure num1Size<=num2Size
            return findMedianSortedArrays(nums2, nums1)
        }
        var low = 0
        var high = num1Size
        while (low <= high) {
            val partitionNum1 = (low + high) / 2
            val partitionNum2 = (num1Size + num2Size + 1) / 2 - partitionNum1

            val maxLeftNum1 = if (partitionNum1 == 0) Int.MIN_VALUE else nums1[partitionNum1 - 1]
            val minRightNum1 = if (partitionNum1 == num1Size) Int.MAX_VALUE else nums1[partitionNum1]

            val maxLeftNum2 = if (partitionNum2 == 0) Int.MIN_VALUE else nums2[partitionNum2 - 1]
            val minRightNum2 = if (partitionNum2 == num2Size) Int.MAX_VALUE else nums2[partitionNum2]

            if (maxLeftNum1 <= minRightNum2 && minRightNum1 >= maxLeftNum2) {
                if ((num1Size + num2Size) % 2 == 0) {
                    return (Math.max(maxLeftNum1, maxLeftNum2) + Math.min(minRightNum1, minRightNum2)).toDouble() / 2
                } else {
                    return Math.max(maxLeftNum1, maxLeftNum2).toDouble()
                }
            } else if (maxLeftNum1 > minRightNum2) {
                high = partitionNum1 - 1
            } else {
                low = partitionNum1 + 1
            }
        }
        // we can come here only if the arrays are not sorted
        return -1.0
    }
}