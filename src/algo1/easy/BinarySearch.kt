package algo1.easy

/**
 * Given an array of integers nums which is sorted in ascending order, and an integer target,
 * write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
 * You must write an algorithm with O(log n) runtime complexity.
 * time O(logN) / space O(1)
 */
class BinarySearch {
    fun search(nums: IntArray, target: Int): Int {
        if (nums.isEmpty()) return -1
        var leftIndex = 0
        var rightIndex = nums.size-1

        while (leftIndex <= rightIndex) {
            val newIndex = leftIndex + (rightIndex - leftIndex)/2
            if (nums[newIndex] == target)
                return newIndex
            if (target < nums[newIndex])
                rightIndex = newIndex-1
            else
                leftIndex = newIndex+1
        }
        return -1
    }
}