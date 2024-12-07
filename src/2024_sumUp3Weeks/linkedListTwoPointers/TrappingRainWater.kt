package `2024_sumUp3Weeks`.linkedListTwoPointers

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 */

class TrappingRainWater {
    fun trap(height: IntArray): Int {
        var currentTotal = 0
        var leftIndex = 0
        var rightIndex = height.size - 1
        var leftMax = 0
        var rightMax = 0

        while (leftIndex < rightIndex) {
            if (height[leftIndex] < height[rightIndex]) {
                // Move from the left
                leftMax = leftMax.coerceAtLeast(height[leftIndex])
                currentTotal += (leftMax - height[leftIndex]).coerceAtLeast(0)
                leftIndex++
            } else {
                // Move from the right
                rightMax = rightMax.coerceAtLeast(height[rightIndex])
                currentTotal += (rightMax - height[rightIndex]).coerceAtLeast(0)
                rightIndex--
            }
        }

        return currentTotal
    }
}