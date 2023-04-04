package `75plan`.level1

/**
 * Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
 * Return the running sum of nums.
 */
class RunningSumOf1dArray {
    // time / space O(n)
    fun runningSum(nums: IntArray): IntArray {
        val resultArray = MutableList(0) {0}
        var currentSum = 0
        nums.forEach { currentNumber ->
            currentSum += currentNumber
            resultArray.add(currentSum)
        }
        return resultArray.toIntArray()
    }
}