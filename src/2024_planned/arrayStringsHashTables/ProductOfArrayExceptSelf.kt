package `2024_planned`.arrayStringsHashTables

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 */
class ProductOfArrayExceptSelf {
    fun productExceptSelf(nums: IntArray): IntArray {
        val n = nums.size
        val answer = IntArray(n) { 1 }

        // Left pass: calculate products of all elements to the left of each index
        var leftProduct = 1
        for (i in 0 until n) {
            answer[i] = leftProduct
            leftProduct *= nums[i]
        }

        // Right pass: calculate products of all elements to the right and multiply
        var rightProduct = 1
        for (i in n - 1 downTo 0) {
            answer[i] *= rightProduct
            rightProduct *= nums[i]
        }

        return answer
    }
}