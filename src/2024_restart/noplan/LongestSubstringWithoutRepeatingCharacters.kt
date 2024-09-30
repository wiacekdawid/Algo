package `2024_restart`.noplan

import java.util.*

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 */

// time O(n) / space O(1)
class LongestSubstringWithoutRepeatingCharacters {
    fun lengthOfLongestSubstring(s: String): Int {
        var longest = 0
        val checkingList = LinkedList<Char>()
        s.forEach {
            while (checkingList.contains(it)) {
                checkingList.removeFirst()
            }
            checkingList.addLast(it)
            longest = checkingList.size.coerceAtLeast(longest)
        }
        return longest
    }
}