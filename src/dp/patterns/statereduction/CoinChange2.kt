package dp.patterns.statereduction

import kotlin.math.sign

/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
 * You may assume that you have an infinite number of each kind of coin.
 * The answer is guaranteed to fit into a signed 32-bit integer.
 */

class CoinChange2 {

    // brute force time O(2^(amount+number of coins)) / space O(amount + num of coins)
    fun change1(amount: Int, coins: IntArray): Int {
        return brute(0, amount, coins)
    }

    private fun brute(current: Int, amount: Int, coins: IntArray): Int {
        if (amount == 0) {
            return 1
        }

        if (current >= coins.size) {
            return 0
        }

        val currentCoin = coins[current]
        var c1 = 0

        if ((amount - currentCoin) >= 0)
            c1 = brute(current, amount - currentCoin, coins)

        val c2 = brute(current+1, amount, coins)

        return c1 + c2
    }

    // top down 2D time O(n * amount) / space O(amount)
    private lateinit var cache: Array<IntArray>

    fun change2(amount: Int, coins: IntArray): Int {
        cache = Array(amount+1) { IntArray(coins.size) { -1 } }
        return dp(0, amount, coins)
    }

    private fun dp(currentCoin: Int, currentAmount: Int, coins: IntArray): Int {
        if (currentAmount == 0)
            return 1

        if (currentCoin >= coins.size)
            return 0

        if (cache[currentAmount][currentCoin] == -1) {
            val currentCoin = coins[currentCoin]
            var c1 = 0

            if ((currentAmount - currentCoin) >= 0)
                c1 = dp(currentCoin, currentAmount - currentCoin, coins)

            val c2 = dp(currentCoin+1, currentAmount, coins)

            cache[currentAmount][currentCoin] = c1 + c2
        }

        return cache[currentAmount][currentCoin]
    }

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
}