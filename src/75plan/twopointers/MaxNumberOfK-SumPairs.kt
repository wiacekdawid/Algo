package `75plan`.twopointers

/**
 * You are given an integer array nums and an integer k.
 * In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
 * Return the maximum number of operations you can perform on the array.
 */

class `MaxNumberOfK-SumPairs` {
    // time / space O(n)
    fun maxOperations(nums: IntArray, k: Int): Int {
        val map = mutableMapOf<Int, Int>()

        nums.forEach {
            map[it] = (map[it] ?: 0) + 1
        }

        var count = 0

        nums.forEach {
            val complement = k - it
            if (map.getOrDefault(it, 0) > 0 && map.getOrDefault(complement, 0) > 0) {
                if (!(it == complement && map.getOrDefault(it, 0) < 2)) {
                    map[it] = map.getOrDefault(it, 0) - 1
                    map[complement] = map.getOrDefault(complement, 0) - 1
                    count++
                }
            }
        }
        return count
    }
}