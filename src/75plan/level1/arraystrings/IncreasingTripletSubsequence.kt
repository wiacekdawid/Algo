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
        var smallest = Integer.MAX_VALUE
        var medium = Integer.MAX_VALUE
        nums.forEach {
            if (it <= smallest) {
                smallest = it
            } else if (it <= medium) {
                medium = it
            } else {
                return true
            }
        }
        return false
    }
}