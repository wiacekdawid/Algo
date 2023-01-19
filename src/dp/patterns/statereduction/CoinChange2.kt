package dp.patterns.statereduction

import kotlin.math.sign

/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
 * You may assume that you have an infinite number of each kind of coin.
 * The answer is guaranteed to fit into a signed 32-bit integer.
 */

class CoinChange2 {

    // bottom up time O(n * amount) / space O(amount)
    fun change(amount: Int, coins: IntArray): Int {
        val cache = IntArray(amount+1)
        cache[0] = 1

        coins.forEach { currentCoin ->
            for (currentAmount in currentCoin until amount+1) {
                cache[currentAmount] += cache[currentAmount - currentCoin]
            }
        }
        return cache[amount]
    }

    // top down time O(n * amount) / space O(amount)
    private lateinit var cache: IntArray

    fun change2(amount: Int, coins: IntArray): Int {
        cache = IntArray(amount+1) { -1 }
        cache[0] = 1

        coins.forEach { currentCoin ->
            for (currentAmount in currentCoin until amount+1) {
                cache[currentAmount] += cache[currentAmount - currentCoin]
            }
        }
        return cache[amount]
    }

    private fun dp(currentAmount: Int, amount: Int, coins: IntArray): Int {
        if (currentAmount == 0)
            return 1

        if (cache[currentAmount] == -1) {
            coins.forEach { currentCoin ->
                for (currentAmount in currentCoin until amount+1) {
                    cache[currentAmount] =
                }
            }
        }

        return cache[currentAmount]
    }
}