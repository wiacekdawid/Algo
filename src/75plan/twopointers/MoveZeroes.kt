package `75plan`.twopointers

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 */

class MoveZeroes {
    // time O(n) space O(1)
    fun moveZeroes(nums: IntArray): Unit {
        var currInd = 0
        var numOfZeroes = 0

        while (currInd < nums.size) {
            if (nums[currInd] != 0) {
                nums[currInd - numOfZeroes] = nums[currInd]
            } else {
                numOfZeroes++
            }
            currInd++
        }

        currInd = nums.size - numOfZeroes

        while(currInd < nums.size) {
            nums[currInd] = 0
            currInd++
        }
    }
}