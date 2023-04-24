package `75plan`.level1.arraystrings

/**
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1.
 * If a string is longer than the other, append the additional letters onto the end of the merged string.
 * Return the merged string.
 */
class MergeStringsAlternately {
    // time O(s1 + s2) / space O(1)
    fun mergeAlternately(word1: String, word2: String): String {
        var s1 = 0
        var s2 = 0
        val sb = StringBuilder(word1.length + word2.length - 1)
        while (s1 < word1.length || s2 < word2.length) {
            if (s1 < word1.length) {
                sb.append(word1[s1])
                s1++
            }
            if (s2 < word2.length) {
                sb.append(word2[s2])
                s2++
            }
        }

        return sb.toString()
    }
}