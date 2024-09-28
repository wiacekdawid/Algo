package `2024_restart`.noplan


/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 */

// time / space O(n)
class TrappingRainWater {
    fun trap(height: IntArray): Int {
        // Case of empty height array
        if (height.isEmpty()) return 0
        var ans = 0
        val size: Int = height.size
        // Create left and right max arrays
        val leftMax = IntArray(size)
        val rightMax = IntArray(size)
        // Initialize first height into left max
        leftMax[0] = height[0]
        for (i in 1 until size) {
            // update left max with current max
            leftMax[i] = height[i].coerceAtLeast(leftMax[i - 1])
        }
        // Initialize last height into right max
        rightMax[size - 1] = height[size - 1]
        for (i in size - 2 downTo 0) {
            // update right max with current max
            rightMax[i] = height[i].coerceAtLeast(rightMax[i + 1])
        }
        // Calculate the trapped water
        for (i in 1 until size - 1) {
            ans += leftMax[i].coerceAtMost(rightMax[i]) - height[i]
        }
        // Return amount of trapped water
        return ans
    }
}