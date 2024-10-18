package `2024_planned`.hashTables

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.
 */

// time / space O(n+m)
class IntersectionOfTwoArrays {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        if (nums1.isEmpty() || nums2.isEmpty()) return IntArray(0)

        val setForNum1 = nums1.toSet()
        val intersectionContainer = nums2.filter { it in setForNum1 }.toSet()

        return intersectionContainer.toIntArray()
    }
}