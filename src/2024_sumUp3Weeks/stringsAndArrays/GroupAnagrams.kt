package `2024_sumUp3Weeks`.stringsAndArrays

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 */
// time O(n x k x logK) / space O(n x k)
class GroupAnagrams {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val results = mutableMapOf<String, MutableList<String>>()

        strs.forEach {
            val sortedStr = it.toCharArray().sorted().joinToString("")
            results.computeIfAbsent(sortedStr) { mutableListOf() }.add(it)
        }

        return results.values.toList()
    }
}