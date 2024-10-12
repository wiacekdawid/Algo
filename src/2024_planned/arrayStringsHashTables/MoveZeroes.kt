package `2024_planned`.arrayStringsHashTables

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 */

// time O(N) / space O(1)
class MoveZeroes {
    fun moveZeroes(nums: IntArray): Unit {
        var indexOfNonZeroes = 0
        nums.forEach { i ->
            if (i != 0) {
                nums[indexOfNonZeroes++] = i
            }
        }

        while (indexOfNonZeroes < nums.size) {
            nums[indexOfNonZeroes++] = 0
        }
    }
}