package `2024_planned`.dp

/**
 * You have intercepted a secret message encoded as a string of numbers. The message is decoded via the following mapping:
 * "1" -> 'A' "2" -> 'B' ... "25" -> 'Y' "26" -> 'Z'
 * However, while decoding the message, you realize that there are many different ways you can decode the message because some codes are contained in other codes ("2" and "5" vs "25").
 * For example, "11106" can be decoded into:
 * "AAJF" with the grouping (1, 1, 10, 6) "KJF" with the grouping (11, 10, 6)
 * The grouping (1, 11, 06) is invalid because "06" is not a valid code (only "6" is valid).
 * Note: there may be strings that are impossible to decode.
 * Given a string s containing only digits, return the number of ways to decode it. If the entire string cannot be decoded in any valid way, return 0.
 * The test cases are generated so that the answer fits in a 32-bit integer.
 */

// time / space O(n)
class DecodeWays {
    fun numDecodings(s: String): Int {
        if (s.isEmpty() || s[0] == '0') return 0

        val n = s.length
        val dp = IntArray(n + 1) { 0 }
        dp[0] = 1 // Base case: empty string
        dp[1] = 1 // Base case: first character is valid

        for (i in 2..n) {
            val oneDigit = s.substring(i - 1, i).toInt()
            val twoDigits = s.substring(i - 2, i).toInt()

            if (oneDigit in 1..9) {
                dp[i] += dp[i - 1] // Add ways from previous single digit
            }

            if (twoDigits in 10..26) {
                dp[i] += dp[i - 2] // Add ways from previous two digits
            }
        }

        return dp[n]
    }
}