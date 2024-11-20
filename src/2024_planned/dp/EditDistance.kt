package `2024_planned`.dp

/**
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 * You have the following three operations permitted on a word:
 * Insert a character / Delete a character / Replace a character
 */

// time / space O(m x n)
class EditDistance {
    fun minDistance(word1: String, word2: String): Int {
        val m = word1.length
        val n = word2.length
        val dp = Array(m + 1) { IntArray(n + 1) }

        // Base cases
        for (i in 0..m) dp[i][0] = i
        for (j in 0..n) dp[0][j] = j

        // Fill DP table
        for (i in 1..m) {
            for (j in 1..n) {
                if (word1[i - 1] == word2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1]
                } else {
                    dp[i][j] = 1 + minOf(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1])
                }
            }
        }

        return dp[m][n]
    }
}