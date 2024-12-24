package `2024_summary`

/**
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once.
 * The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
 * Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
 * Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially.
 * The remaining elements of nums are not important as well as the size of nums.
 * Return k.
 */

class RemoveDuplicatesFromSortedArray {
    // time O(n) / space O(1)
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        var leftIndex = 0
        var rightIndex = 1

        while (rightIndex < nums.size) {
            if (nums[leftIndex] != nums[rightIndex]) {
                nums[++leftIndex] = nums[rightIndex]
            }
            rightIndex++
        }
        return leftIndex+1
    }
}