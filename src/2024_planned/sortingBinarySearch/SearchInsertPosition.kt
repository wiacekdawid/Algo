package `2024_planned`.sortingBinarySearch

/**
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You must write an algorithm with O(log n) runtime complexity.
 */
// time O(logn) / space O(1)
class SearchInsertPosition {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var leftIndex = 0
        var rightIndex = nums.size-1

        while (leftIndex <= rightIndex) {
            val mid = leftIndex + (rightIndex - leftIndex)/2
            if (nums[mid] == target) {
                return mid
            } else if (target > nums[mid]) {
                leftIndex = mid+1
            } else {
                rightIndex = mid-1
            }
        }
        return leftIndex
    }
}