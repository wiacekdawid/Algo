package dp.more

import kotlin.math.pow

/**
 * Given an integer n, your task is to count how many strings of length n can be formed under the following rules:
 * Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
 * Each vowel 'a' may only be followed by an 'e'.
 * Each vowel 'e' may only be followed by an 'a' or an 'i'.
 * Each vowel 'i' may not be followed by another 'i'.
 * Each vowel 'o' may only be followed by an 'i' or a 'u'.
 * Each vowel 'u' may only be followed by an 'a'.
 * Since the answer may be too large, return it modulo 10^9 + 7.
 */

class CountVowelsPermutation {

    // top down space/time
    lateinit var dp: Array<IntArray>
    private val map = mapOf('a' to 0, 'e' to 1, 'i' to 2, 'o' to 3, 'u' to 4)
    private val maxValue = 10.0.pow(9.0) + 7
    fun countVowelPermutation(n: Int): Int {
        dp = Array(n+1) { IntArray(map.size+1) { -1 } }
        var result = 0
        map.forEach {
            result += dp(n, it.key)
        }
        if (result > maxValue || result < 0) return maxValue.toInt()
        return result
    }

    private fun dp(n: Int, previousVowel: Char): Int {
        if (n == 1) {
            return 1
        }
        if (dp[n][map.getOrDefault(previousVowel, 0)] == -1) {
            dp[n][map.getOrDefault(previousVowel, 0)] = when (previousVowel) {
                'a' -> {
                    dp(n-1, 'e')
                }
                'e' -> {
                    dp(n-1, 'a') + dp(n-1, 'i')
                }
                'i' -> {
                    dp(n-1, 'a') + dp(n-1, 'e') + dp(n-1, 'o') + dp(n-1, 'u')
                }
                'o' -> {
                    dp(n-1, 'i') + dp(n-1, 'u')
                }
                else -> {
                    dp(n-1, 'a')
                }
            }
        }
        return dp[n][map.getOrDefault(previousVowel, 0)]
    }
}