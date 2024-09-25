package `2024_restart`.noplan

/**
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 */

// time / space O(n)
class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        // Create a HashMap to store the value and its index
        val seen = mutableMapOf<Int, Int>()

        // Loop through the array
        nums.forEachIndexed { index, num ->
            // Calculate the complement
            val complement = target - num

            // If the complement is found in the map, return the indices
            if (seen.containsKey(complement)) {
                return intArrayOf(seen[complement]!!, index)
            }

            // Otherwise, add the current number and its index to the map
            seen[num] = index
        }

        // If no solution is found (though the problem guarantees one), return an empty array
        return intArrayOf()
    }
}