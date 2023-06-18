package `75plan`.hashmapset

/**
 * Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
 * answer[0] is a list of all distinct integers in nums1 which are not present in nums2
 * answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
 * Note that the integers in the lists may be returned in any order.
 */

class FindTheDifferenceOfTwoArrays {
    // time O(n+m) / space O(max(n,m)) where n/m length of arrays
    fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
        val set1 = nums1.toSet()
        val set2 = nums2.toSet()
        val answer1 = HashSet<Int>()
        val answer2 = HashSet<Int>()
        nums1.forEach {
            if (!set2.contains(it)) answer1.add(it)
        }
        nums2.forEach {
            if (!set1.contains(it)) answer2.add(it)
        }
        return listOf(answer1.toList(), answer2.toList())
    }
}