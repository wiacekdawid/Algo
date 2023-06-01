package `75plan`.twopointers

/**
 * You are given an integer array nums and an integer k.
 * In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
 * Return the maximum number of operations you can perform on the array.
 */

class `MaxNumberOfK-SumPairs` {
    fun maxOperations(nums: IntArray, k: Int): Int {
        val map = mutableMapOf<Int, Int>()

        nums.forEach {
            map[it] = (map[it]?.orDefault(0)) + 1
        }

    }
}