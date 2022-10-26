package dp

import kotlin.test.currentStackTrace

/**
 * You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:
 * Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
 * Return the maximum number of points you can earn by applying the above operation some number of times.
 */
fun main() {
    val result = DeleteAndEarn().deleteAndEarn(intArrayOf(2,2,3,3,3,4))
    val result1 = result
}

class DeleteAndEarn {

    // top down time / space O(N+k) N is size of nums and k max number in nums
    private val points = mutableMapOf<Int, Int>()
    private val cache = mutableMapOf<Int, Int>()

    fun deleteAndEarn(nums: IntArray): Int {
        var maxNumber = 0
        nums.forEach { currentValue ->
            points[currentValue] = points.getOrDefault(currentValue, 0) + currentValue
            maxNumber = maxNumber.coerceAtLeast(currentValue)
        }

        return maxPoints(maxNumber)
    }

    private fun maxPoints(num: Int): Int {
        if (num == 0) {
            return 0
        }

        if (num == 1) {
            return points.getOrDefault(1, 0)
        }

        if (!cache.containsKey(num)) {
            val currentGain = points.getOrDefault(num, 0)
            cache[num] = (currentGain + maxPoints(num-2)).coerceAtLeast(maxPoints(num-1))
        }

        return cache.getOrDefault(num, 0)
    }

    /** bottom up time/space O(N+k)
     * this one could be also space optimized (O(N)) to use only last two values instead of array
     */
    fun deleteAndEarn2(nums: IntArray): Int {
        val points = mutableMapOf<Int, Int>()

        var maxNumber = 0
        nums.forEach { currentValue ->
            points[currentValue] = points.getOrDefault(currentValue, 0) + currentValue
            maxNumber = maxNumber.coerceAtLeast(currentValue)
        }

        val maxPoints = IntArray(size = maxNumber+1)

        maxPoints[0] = 0
        maxPoints[1] = points.getOrDefault(1, 0)

        for (i in 2 until maxNumber+1) {
            val currentGain = points.getOrDefault(i, 0)
            maxPoints[i] = (maxPoints[i-1]).coerceAtLeast(maxPoints[i-2] + currentGain)
        }

        return maxPoints[maxNumber]
    }

}