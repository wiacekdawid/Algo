package arraysandstrings

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 * Time/Space O(n)/O(1)
 */

class MoveZeroes {
    fun moveZeroes(nums: IntArray): Unit {
        if (nums.isEmpty()) return

        var currentIndexOfNumbers = 0

        for (currentIndex in nums.indices) {
            if (nums[currentIndex] != 0) {
                nums[currentIndexOfNumbers] = nums[currentIndex]
                currentIndexOfNumbers++
            }
        }
        for (i in currentIndexOfNumbers until nums.size) {
            nums[i] = 0
        }
    }
}