package dp.more

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

    // top down space/time O(n)
    lateinit var memo: Array<LongArray>
    private val maxValue = 1000000007
    fun countVowelPermutation(n: Int): Int {
        memo = Array(n) { LongArray(5) { 0 } }
        var result: Long = 0
        for (index in 0 until 5) {
            result = (result + dp(n-1, index)) % maxValue
        }
        return result.toInt()
    }

    private fun dp(n: Int, vowel: Int): Long {
        if (memo[n][vowel] != 0L) {
            return memo[n][vowel]
        }
        if (n == 0) {
            memo[n][vowel] = 1
        }
        if (memo[n][vowel] == 0L) {
             when (vowel) {
                0 -> {
                    memo[n][vowel] = (dp(n-1, 1) + dp(n-1, 2) + dp(n-1, 4)) % maxValue
                }
                1 -> {
                    memo[n][vowel] = (dp(n-1, 0) + dp(n-1, 2)) % maxValue
                }
                2 -> {
                    memo[n][vowel] = (dp(n-1, 1) + dp(n-1, 3))% maxValue
                }
                3 -> {
                    memo[n][vowel] = dp(n-1, 2) % maxValue
                }
                4 -> {
                    memo[n][vowel] = (dp(n-1, 2) + dp(n-1, 3))% maxValue
                }
                else -> {

                }
            }
        }
        return memo[n][vowel]
    }

    // bottom up space/time O(n)
    lateinit var memo: Array<LongArray>
    private val maxValue = 1000000007
    fun countVowelPermutation2(n: Int): Int {
        return 0
    }
}