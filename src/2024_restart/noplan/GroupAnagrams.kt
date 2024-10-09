package `2024_restart`.noplan


/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 */

fun main() {
    val result = GroupAnagrams().groupAnagrams(arrayOf("eat","tea","tan","ate","nat","bat"))
}

/**
 * Time O(NKlogK) where K is max length of string in str and n is num of strings in str / space O(NK)
 */
class GroupAnagrams {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val groupedAnagrams = HashMap<String, MutableList<String>>()

        strs.forEach { str ->
            // Sort the characters of the string and use as the key
            val sortedStr = str.toCharArray()
            sortedStr.sort()
            val key = String(sortedStr)

            // Add the string to the list associated with the sorted key
            if (groupedAnagrams.containsKey(key)) {
                groupedAnagrams[key]?.add(str)
            } else {
                groupedAnagrams[key] = mutableListOf(str)
            }
        }

        // Convert the values of the map into a list of lists
        return groupedAnagrams.values.toList()
    }
}