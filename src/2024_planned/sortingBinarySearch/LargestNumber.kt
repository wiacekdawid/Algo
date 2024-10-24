package `2024_planned`.sortingBinarySearch

/**
 * Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
 * Since the result may be very large, so you need to return a string instead of an integer.
 */

// time O(nlogn) / space O(n)
class LargestNumber {
    fun largestNumber(nums: IntArray): String {
        // Convert numbers to strings
        val numsAsStrings = nums.map { it.toString() }

        // Sort the numbers by comparing concatenated results
        val sorted = numsAsStrings.sortedWith { a, b ->
            // Compare two possible concatenations: (a + b) and (b + a)
            (b + a).compareTo(a + b)
        }

        // Join the sorted numbers into a single string
        val result = sorted.joinToString("")

        // Edge case: If the result starts with '0', it means all numbers were zeros (e.g., [0, 0])
        return if (result.startsWith('0')) "0" else result
    }
}