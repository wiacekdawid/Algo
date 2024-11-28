package `2024_sumUp3Weeks`.stringsAndArrays

/**
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
 */

// time O(n+m) / space O(1)
class FindAllAnagramsInAString {
    fun findAnagrams(s: String, p: String): List<Int> {
        if (p.length > s.length) return emptyList()

        val pCount = IntArray(26)
        val sCount = IntArray(26)
        val output = mutableListOf<Int>()

        // Initialize frequency counts for `p` and the first window of `s`
        for (i in p.indices) {
            pCount[p[i] - 'a']++
            sCount[s[i] - 'a']++
        }

        // Check if the first window is an anagram
        if (pCount contentEquals sCount) output.add(0)

        // Slide the window
        for (i in p.length until s.length) {
            // Add the new character to the window
            sCount[s[i] - 'a']++
            // Remove the old character from the window
            sCount[s[i - p.length] - 'a']--

            // Check if the current window is an anagram
            if (pCount contentEquals sCount) output.add(i - p.length + 1)
        }

        return output
    }
}