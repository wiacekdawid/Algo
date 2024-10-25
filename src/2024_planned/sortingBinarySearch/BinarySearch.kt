package `2024_planned`.sortingBinarySearch

/**
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums.
 * If target exists, then return its index. Otherwise, return -1.
 * You must write an algorithm with O(log n) runtime complexity.
 */
// time O(logn) / space O(1)
class BinarySearch {
    fun search(nums: IntArray, target: Int): Int {
        if (nums.isEmpty()) return -1
        if (nums.first() > target || nums.last() < target) return -1
        var leftIndex = 0
        var rightIndex = nums.size-1

        while (leftIndex <= rightIndex) {
            val mid = leftIndex + (rightIndex - leftIndex) / 2
            if (nums[mid] == target) {
                return mid  // Return the index of the target
            } else if (target > nums[mid]) {
                leftIndex = mid + 1  // Move left boundary to the right of mid
            } else {
                rightIndex = mid - 1  // Move right boundary to the left of mid
            }
        }
        return -1
    }
}