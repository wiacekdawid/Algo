package dp

/**
 * Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 * time O(M*N) / space O(min(M,N)) where M is length of first word and N is the lenght of second word
 */

class LongestCommonSubsequence {
    private lateinit var memo: Array<IntArray>
    private lateinit var text1: String
    private lateinit var text2: String

    /**
     * top - down / time O(s1 * (pow 2 s2) / space O(s1 * s2)
     */
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        memo = Array(text1.length) { IntArray(text2.length) { -1 } }
        this.text1 = text1
        this.text2 = text2
        return dp(0, 0)
    }

    private fun dp(p1: Int, p2: Int): Int {
        if (memo[p1][p2] != -1) {
            return memo[p1][p2]
        }

        // Option 1: we don't include text1[p1] in the solution.
        val option1: Int = dp(p1 + 1, p2)


        // Option 2: We include text1[p1] in the solution, as long as
        // a match for it in text2 at or after p2 exists.
        val firstOccurence = text2.indexOf(text1[p1], p2)
        var option2 = 0
        if (firstOccurence != -1) {
            option2 = 1 + dp(p1 + 1, firstOccurence + 1)
        }

        // Add the best answer to the memo before returning it.
        memo[p1][p2] = option1.coerceAtLeast(option2)
        return memo[p1][p2]
    }

    /**
     * bottom - up / time O(s1 * (pow 2 s2) / space O(s1 * s2)
     */
    fun longestCommonSubsequence2(text1: String, text2: String): Int {
        memo = Array(text1.length) { IntArray(text2.length) { -1 } }
        this.text1 = text1
        this.text2 = text2
        return dp(0, 0)
    }
}