package dp.patterns.statereduction

import kotlin.math.sign

/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
 * You may assume that you have an infinite number of each kind of coin.
 * The answer is guaranteed to fit into a signed 32-bit integer.
 */

// bottom up time O(n * amount) / space O(amount)
class CoinChange2 {
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
}