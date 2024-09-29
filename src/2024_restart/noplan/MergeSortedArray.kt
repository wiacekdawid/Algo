package `2024_restart`.noplan

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 */

// time O(m+n) / space O(1)

class MergeSortedArray {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var i = m - 1
        var j = n - 1
        var k = m + n -1
        while (j >= 0) {
            nums1[k--] = if (i < 0 || nums1[i] < nums2[j]) nums2[j--] else nums1[i--]
        }
    }
}