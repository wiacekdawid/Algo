package `75plan`.twopointers

/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 */
class ContainerWithMostWater {
    // time O(n) space O(1)
    fun maxArea(height: IntArray): Int {
        var maxArea = 0

        var pStart = 0
        var pEnd = height.size-1

        while(pStart < pEnd) {
            val currentHeight = height[pStart].coerceAtMost(height[pEnd])
            maxArea = maxArea.coerceAtLeast(currentHeight * (pEnd - pStart))

            if (height[pStart] <= height[pEnd]) {
                pStart++
            } else {
                pEnd--
            }
        }
        return maxArea
    }
}