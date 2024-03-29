package `75plan`.prefixsum

/**
 * Given an array of integers nums, calculate the pivot index of this array.
 * The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.
 * If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.
 * Return the leftmost pivot index. If no such index exists, return -1.
 */

class FindPivotIndex {
    // time O(n) space O(1)
    fun pivotIndex(nums: IntArray): Int {
        val totalSum = nums.sum()
        var leftSum = 0
        nums.forEachIndexed { index, i ->
            if (leftSum == totalSum - leftSum - i) {
                return index
            }
            leftSum += i
        }
        return -1
    }
}