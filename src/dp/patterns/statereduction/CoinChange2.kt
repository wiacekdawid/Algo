package dp.patterns.statereduction

import kotlin.math.sign

/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
 * You may assume that you have an infinite number of each kind of coin.
 * The answer is guaranteed to fit into a signed 32-bit integer.
 */

fun main() {
    val test = CoinChange2().change2(5, intArrayOf(1, 2, 5))
}

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

    // top down 2D time O(n * amount) / space O(n * amount)
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
            val currentCoinValue = coins[currentCoin]
            var c1 = 0

            if ((currentAmount - currentCoinValue) >= 0)
                c1 = dp(currentCoin, currentAmount - currentCoinValue, coins)

            val c2 = dp(currentCoin+1, currentAmount, coins)

            cache[currentAmount][currentCoin] = c1 + c2
        }

        return cache[currentAmount][currentCoin]
    }

    // bottom up 2D time O(n * amount) / space O(n * amount)
    fun change3(amount: Int, coins: IntArray): Int {
        val cache = Array(coins.size) { IntArray(amount+1) { 0 } }

        for (i in coins.indices)
            cache[i][0] = 1

        val firstCoin = coins.first()
        for (currentAmount in 0 until amount+1) {
            if (currentAmount % firstCoin == 0) {
                cache[0][currentAmount] = 1
            }
        }

        for (currentCoinIndex in 1 until coins.size) {
            val currentCoin = coins[currentCoinIndex]

            for (currentAmount in 1 until amount+1) {
                if (currentAmount - currentCoin >= 0) {
                    cache[currentCoinIndex][currentAmount] =
                        cache[currentCoinIndex][currentAmount-currentCoin] + cache[currentCoinIndex-1][currentAmount]
                } else {
                    cache[currentCoinIndex][currentAmount] =
                        cache[currentCoinIndex-1][currentAmount]
                }
            }
        }

        return cache[coins.size-1][amount]
    }

    // bottom up 1D time O(n * amount) / space O(amount)
    fun change4(amount: Int, coins: IntArray): Int {
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