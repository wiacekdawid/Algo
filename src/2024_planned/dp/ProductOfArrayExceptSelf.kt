package `2024_planned`.dp

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 */

// time O(n) / space O(1)
class ProductOfArrayExceptSelf {
    fun productExceptSelf(nums: IntArray): IntArray {
        val output = IntArray(nums.size) { 1 }

        // Step 1: Calculate prefix products
        var currentProd = 1
        for (i in nums.indices) {
            output[i] = currentProd
            currentProd *= nums[i]
        }

        // Step 2: Calculate suffix products and multiply with prefix products
        var currentProdSuffix = 1
        for (i in nums.size - 1 downTo 0) {
            output[i] *= currentProdSuffix
            currentProdSuffix *= nums[i]
        }

        return output
    }
}