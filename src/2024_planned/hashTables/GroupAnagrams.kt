package `2024_planned`.hashTables

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 */

// time O(n⋅klogk) / space O(n*k)
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