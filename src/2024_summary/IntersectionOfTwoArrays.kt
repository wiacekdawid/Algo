package `2024_summary`

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must be unique and you may return the result in any order.
 */
class IntersectionOfTwoArrays {
    // time O(n+m) / space O(n+k) where n/m are lengts of num1/num2 and k is length of intersection
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        val numSet1 = nums1.toSet()
        val outputSet = nums2.filter { it in numSet1 }.toSet()
        return outputSet.toIntArray()
    }
}