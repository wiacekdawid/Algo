package `75plan`.level1.arraystrings

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 */
class ProductOfArrayExceptSelf {
    // time/space O(n)
    fun productExceptSelf(nums: IntArray): IntArray {
        val answer = IntArray(size = nums.size)
        answer[nums.size-1] = nums.last()
        for (i in nums.size-2 downTo 1) {
            answer[i] = nums[i] * answer[i+1]
        }

        answer[0] = answer[1]
        var leftProduct = nums[0]
        for (i in 1 until nums.size) {
            val rightProduct = if (i == nums.size-1) 1 else answer[i+1]
            answer[i] = leftProduct * rightProduct
            leftProduct *= nums[i]
        }
        return answer
    }
}