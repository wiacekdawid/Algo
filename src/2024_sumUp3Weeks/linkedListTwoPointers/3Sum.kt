package `2024_sumUp3Weeks`.linkedListTwoPointers

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 */

// time O(pow2 n) / space O(1)
class `3Sum` {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        nums.sort() // Step 1: Sort the array

        for (i in nums.indices) {
            if (i > 0 && nums[i] == nums[i - 1]) continue // Skip duplicates for the first number

            var left = i + 1
            var right = nums.size - 1

            while (left < right) {
                val sum = nums[i] + nums[left] + nums[right]
                when {
                    sum < 0 -> left++ // Move left pointer to increase the sum
                    sum > 0 -> right-- // Move right pointer to decrease the sum
                    else -> {
                        // Found a triplet
                        result.add(listOf(nums[i], nums[left], nums[right]))

                        // Skip duplicates for the second and third numbers
                        while (left < right && nums[left] == nums[left + 1]) left++
                        while (left < right && nums[right] == nums[right - 1]) right--

                        left++
                        right--
                    }
                }
            }
        }

        return result
    }
}