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
            if (nums[leftIndex] == target) return leftIndex
            if (nums[rightIndex] == target) return rightIndex
            val mid = leftIndex + (rightIndex - leftIndex)/2
            if (nums[mid] == target) {
                return mid
            } else if (target > nums[mid]) {
                leftIndex = mid+1
            } else {
                rightIndex = mid-1
            }
        }
        return -1
    }
}