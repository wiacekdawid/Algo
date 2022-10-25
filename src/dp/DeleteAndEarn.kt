package dp

/**
 * You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:
 * Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
 * Return the maximum number of points you can earn by applying the above operation some number of times.
 */
fun main() {
    val result = DeleteAndEarn().deleteAndEarn(intArrayOf(2,2,3,3,3,4))
    val result1 = result
}

class DeleteAndEarn {

    fun deleteAndEarn(nums: IntArray): Int {
        return dp(nums)
    }

    private fun dp(nums: IntArray) : Int {
        if (nums.isEmpty()) return 0
        if (nums.size == 1) return nums[0]

        var currentMax = 0

        for (i in 0 until nums.size-1) {
            val newMax = nums[i] + dp(removeElement(i, nums))
            currentMax = currentMax.coerceAtLeast(newMax)
        }
        return currentMax
    }

    private fun removeElement(i: Int, nums: IntArray): IntArray {
        val result = nums.toMutableList()
        val currentElement = nums[i]
        result.removeAt(i)
        result.removeAll { it == currentElement+1 || it == currentElement-1 }
        return result.toIntArray()
    }
}