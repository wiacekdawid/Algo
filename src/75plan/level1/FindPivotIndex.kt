package `75plan`.level1

/**
 * Given an array of integers nums, calculate the pivot index of this array.
 * The pivot index is the index where the sum of all the numbers strictly to the left of the
 * index is equal to the sum of all the numbers strictly to the index's right.
 * If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left.
 * This also applies to the right edge of the array.
 * Return the leftmost pivot index. If no such index exists, return -1.
 */

fun main() {
    val test = FindPivotIndex().pivotIndex(intArrayOf(1,7,3,6,5,6))
}

class FindPivotIndex {
    // time O(n) / space O(1)
    fun pivotIndex(nums: IntArray): Int {
        var totalSum = nums.sum()

        var leftSum = 0

        for (i in 0 until nums.size) {
            if (leftSum*2 == totalSum - nums[i]) {
                return i
            }
            leftSum += nums[i]
        }

        return -1
    }
}