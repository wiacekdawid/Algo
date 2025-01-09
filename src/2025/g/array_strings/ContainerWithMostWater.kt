package `2025`.g.array_strings

/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 */

class ContainerWithMostWater {
    // time O(n) / space O(1)
    fun maxArea(height: IntArray): Int {
        if (height.size < 2) return 0

        var currentMax = 0
        var leftIndex = 0
        var rightIndex = height.size - 1

        while (leftIndex < rightIndex) {
            // Calculate the current area
            val currentLevel = height[leftIndex].coerceAtMost(height[rightIndex])
            currentMax = currentMax.coerceAtLeast((rightIndex - leftIndex) * currentLevel)

            // Move the pointer corresponding to the smaller height
            if (height[leftIndex] < height[rightIndex]) {
                leftIndex++
            } else {
                rightIndex--
            }
        }

        return currentMax
    }
}