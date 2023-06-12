package `75plan`.slidingwindow

/**
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
 */

fun main() {
    val test = MaxConsecutiveOnesIII().longestOnes(intArrayOf(1,1,1,0,0,0,1,1,1,1,0), 2)
}

class MaxConsecutiveOnesIII {
    fun longestOnes(nums: IntArray, k: Int): Int {
        if (nums.isEmpty()) return 0
        var numOfNonOnes = 0
        var maxLengthOfString = 0
        var currentLength = 0

        var leftIndex = 0

        for (rightIndex in nums.indices) {
            if (nums[rightIndex] == 0) {
                numOfNonOnes++
                if (numOfNonOnes > k) {
                    while (numOfNonOnes > k) {
                        if (nums[leftIndex] == 0) {
                            numOfNonOnes--
                        }
                        leftIndex++
                        currentLength--
                    }
                } else {
                    currentLength++
                }
            } else {
                currentLength++
            }
            maxLengthOfString = maxLengthOfString.coerceAtLeast(currentLength)
        }

        return maxLengthOfString
    }
}