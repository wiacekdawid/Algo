package `2024_planned`.sortingBinarySearch

/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects
 * of the same color are adjacent, with the colors in the order red, white, and blue.
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * You must solve this problem without using the library's sort function.
 */

// time O(n) space O(1)
class SortColors {
    fun sortColors(nums: IntArray): Unit {
        var leftIndex = 0       // Pointer for the next 0
        var currentIndex = 0    // Pointer for the current element
        var rightIndex = nums.size - 1  // Pointer for the next 2

        while (currentIndex <= rightIndex) {
            when {
                nums[currentIndex] == 0 -> {
                    // Swap current element with the left (next 0 position)
                    nums[currentIndex] = nums[leftIndex].also { nums[leftIndex] = nums[currentIndex] }
                    leftIndex++
                    currentIndex++
                }
                nums[currentIndex] == 2 -> {
                    // Swap current element with the right (next 2 position)
                    nums[currentIndex] = nums[rightIndex].also { nums[rightIndex] = nums[currentIndex] }
                    rightIndex--
                }
                else -> {
                    currentIndex++
                }
            }
        }
    }
}