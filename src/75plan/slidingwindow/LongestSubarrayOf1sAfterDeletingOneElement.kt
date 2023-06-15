package `75plan`.slidingwindow

/**
 * Given a binary array nums, you should delete one element from it.
 * Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.
 */

class LongestSubarrayOf1sAfterDeletingOneElement {
    // time O(n) / space O(1)
    fun longestSubarray(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        var numOfNonOnes = 0
        var maxLengthOfString = 0
        var currentLength = 0

        var leftIndex = 0

        for (rightIndex in nums.indices) {
            if (nums[rightIndex] == 0) {
                numOfNonOnes++
                if (numOfNonOnes > 1) {
                    while (numOfNonOnes > 1) {
                        if (nums[leftIndex] == 0) {
                            numOfNonOnes--
                        } else {
                            currentLength--
                        }
                        leftIndex++
                    }
                } else {
                    currentLength++
                }
            } else {
                currentLength++
            }
            maxLengthOfString = maxLengthOfString.coerceAtLeast(currentLength-1)
        }

        return maxLengthOfString
    }
}