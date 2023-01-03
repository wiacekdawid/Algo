package dp.patterns

/**
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 */

fun main() {
    val test = LongestIncreasingSubsequence().lengthOfLIS2(intArrayOf(0,1,0,3,2,3))
}

class LongestIncreasingSubsequence {

    // simplified time O(n pow 2) , space O(n)
    fun lengthOfLIS2(nums: IntArray): Int {
        val cache = IntArray(nums.size) { 1 }
        for (i in 1 until nums.size)
            for (j in 0 until i) {
                if (nums[i] > nums[j]) {
                    cache[i] = cache[i].coerceAtLeast(cache[j] + 1)
                }
            }


        var maxValue = 0

        cache.forEach {
            maxValue = maxValue.coerceAtLeast(it)
        }

        return maxValue
    }

    // substring solution

    fun lengthOfLIS3(nums: IntArray): Int {
        val sub = mutableListOf<Int>()
        sub.add(nums.first())

        for (i in 1 until nums.size) {
            val num = nums[i]
            if (num > sub.last()) {
                sub.add(num)
            } else {
                var j = 0
                while (num > sub[j]) {
                    j++
                }
                sub[j] = num
            }
        }
        return sub.size
    }

    // simplified substring solution - time O(N logN)

    fun lengthOfLIS4(nums: IntArray): Int {
        val sub = mutableListOf<Int>()
        sub.add(nums.first())

        for (i in 1 until nums.size) {
            val num = nums[i]
            if (num > sub.last()) {
                sub.add(num)
            } else {
                var j = searchForIndex(num, sub)
                sub[j] = num
            }
        }
        return sub.size
    }

    private fun searchForIndex(value: Int, sub: MutableList<Int>): Int {
        var left = 0
        var right = sub.size-1
        while (left < right) {
            val middle = (left + right) / 2
            if (sub[middle] == value)
                return middle

            if (sub[middle] < value) {
                left = middle+1
            } else {
                right = middle
            }
        }
        return left
    }

    // recursion
    private lateinit var maxForPosition: IntArray
    fun lengthOfLIS(nums: IntArray): Int {
        maxForPosition = IntArray(nums.size) { -1 }
        for (i in nums.indices)
            dp(i, nums)

        var maxValue = 0

        maxForPosition.forEach {
            maxValue = maxValue.coerceAtLeast(it)
        }

        return maxValue
    }

    private fun dp(currentPosition: Int, nums: IntArray): Int {
        if (maxForPosition[currentPosition] != -1) {
            maxForPosition[currentPosition]
        } else {
            if (currentPosition == nums.size-1) {
                maxForPosition[currentPosition] = 1
            } else {
                var currentMax = 1
                for (i in currentPosition+1 until nums.size) {
                    if (nums[i] > nums[currentPosition]) {
                        currentMax = currentMax.coerceAtLeast(1 + dp(i, nums))
                    }
                }
                maxForPosition[currentPosition] = currentMax
            }
        }
        return maxForPosition[currentPosition]
    }
}