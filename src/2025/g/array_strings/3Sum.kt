package `2025`.g.array_strings

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 */
class `3Sum` {
    // time / space O(n pow 2)
    fun threeSum(nums: IntArray): List<List<Int>> {
        if (nums.size < 3) return emptyList()
        val output = mutableListOf<List<Int>>()
        nums.sort()

        for (mainIndex in 0 until nums.size-2) {
            if (mainIndex > 0 && nums[mainIndex] == nums[mainIndex-1]) continue
            var left = mainIndex + 1
            var right = nums.size - 1

            while (left < right) {
                val currentSum = nums[mainIndex] + nums[left] + nums[right]
                when {
                    currentSum > 0 -> right-- // decrease sum
                    currentSum < 0 -> left++ // increase sum
                    else -> {
                        // Found a triplet
                        output.add(listOf(nums[mainIndex], nums[left], nums[right]))

                        // Skip duplicates for the second and third numbers
                        while (left < right && nums[left] == nums[left + 1]) left++
                        while (left < right && nums[right] == nums[right - 1]) right--

                        left++
                        right--
                    }
                }
            }
        }

        return output.toList()
    }
}