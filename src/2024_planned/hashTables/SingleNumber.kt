package `2024_planned`.hashTables

/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 */

// time O(n) / space O(1)
class SingleNumber {
    fun singleNumber(nums: IntArray): Int {
        var result = 0

        nums.forEach {
            result = result xor it
        }

        return result
    }
    // not meeting space requirement
    fun singleNumber2(nums: IntArray): Int {
        val duplicate = mutableMapOf<Int, Int>()

        nums.forEach {
            duplicate[it] = duplicate.getOrDefault(it, 0) + 1
        }

        return duplicate.filterValues { it == 1 }.keys.first()
    }
}