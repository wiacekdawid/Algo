package `2024_sumUp3Weeks`.linkedListTwoPointers

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
 */
// time O(n) / space O(n)
class IntersectionOfTwoArraysII {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val visited = HashMap<Int, Int>()
        nums1.forEach {
            visited[it] = visited.getOrDefault(it, 0) + 1
        }

        val output = mutableListOf<Int>()

        nums2.forEach {
            if (visited.containsKey(it) && visited[it]!! > 0) {
                output.add(it)
                visited[it] = visited[it]!! - 1
            }
        }

        return output.toIntArray()
    }
}