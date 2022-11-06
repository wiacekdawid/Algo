package dp

/**
 * Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 * time O(M*N) / space O(min(M,N)) where M is length of first word and N is the lenght of second word
 */

fun main() {
    val result = LongestCommonSubsequence().longestCommonSubsequence2("abcde", "ace")
}

class LongestCommonSubsequence {

    /**
     * top - down / time O(s1 * (pow 2 s2) / space O(s1 * s2)
     */
    private lateinit var cache: Array<IntArray>

    fun longestCommonSubsequence(text1: String, text2: String): Int {
        cache = Array(text1.length) { IntArray(text2.length) { -1 } }

        return dp(0, 0, text1, text2)
    }


    private fun dp(index1: Int, index2: Int, text1: String, text2: String): Int {
        if (index1 >= text1.length || index2 >= text2.length)
            return 0

        if (cache[index1][index2] == -1) {
            cache[index1][index2] =
                if (text1[index1] == text2[index2]) {
                    1 + dp(index1 + 1, index2 + 1, text1, text2)
                } else {
                    dp(index1 + 1, index2, text1, text2).coerceAtLeast(dp(index1, index2 + 1, text1, text2))
                }
        }

        return cache[index1][index2]
    }

    /**
     * bottom - up / time O(s1 * s2) / space O(s1 * s2)
     */
    fun longestCommonSubsequence2(text1: String, text2: String): Int {
        val results = Array(text1.length + 1) { IntArray(text2.length + 1) { 0 } }
        for (index1 in 1 until text1.length + 1) {
            for (index2 in 1 until text2.length + 1) {
                if (text1[index1 - 1] == text2[index2 - 1]) {
                    results[index1][index2] = 1 + results[index1 - 1][index2 - 1]
                } else {
                    results[index1][index2] = results[index1][index2 - 1].coerceAtLeast(results[index1 - 1][index2])
                }
            }
        }
        return results[text1.length][text2.length]
    }
}