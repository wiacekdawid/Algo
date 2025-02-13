package `2025`.g.array_strings

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 */

// time O(n) / space O(1)
class TrappingRainWater {
    fun trap(height: IntArray): Int {
        if (height.isEmpty()) return 0

        var left = 0
        var right = height.size - 1
        var leftMax = height[left]
        var rightMax = height[right]
        var totalWater = 0

        while (left < right) {
            if (leftMax < rightMax) {
                left++
                leftMax = maxOf(leftMax, height[left])
                totalWater += maxOf(0, leftMax - height[left])
            } else {
                right--
                rightMax = maxOf(rightMax, height[right])
                totalWater += maxOf(0, rightMax - height[right])
            }
        }

        return totalWater
    }
}