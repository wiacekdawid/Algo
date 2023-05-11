package `75plan`.level1.arraystrings

/**
 * Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k].
 * If no such indices exists, return false.
 */

fun main() {
    val test = IncreasingTripletSubsequence().increasingTriplet(intArrayOf(20, 100, 10, 12, 5, 13))
}
class IncreasingTripletSubsequence {
    // time O(n)/ space O(1)
    fun increasingTriplet(nums: IntArray): Boolean {
        var smallest = nums.first()
        var medium = Integer.MIN_VALUE
        for (i in 1 until nums.size) {
            if (nums[i] < smallest) {
                smallest = nums[i]
                medium = Integer.MIN_VALUE
            } else if (medium > smallest) {
                if (nums[i] > medium) {
                    return true
                }
            } else if (nums[i] > smallest) {
                medium = nums[i]
            }
        }
        return false
    }
}