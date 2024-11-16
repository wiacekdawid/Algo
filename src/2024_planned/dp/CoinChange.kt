package `2024_planned`.dp

/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * You may assume that you have an infinite number of each kind of coin.
 */

// time O(n x m) / space O(n)
class CoinChange {
    // iterative approach
    fun coinChange(coins: IntArray, amount: Int): Int {
        val dp = IntArray(amount + 1) { Int.MAX_VALUE }
        dp[0] = 0 // Base case: 0 coins needed for amount 0

        for (i in 1..amount) {
            for (coin in coins) {
                if (i - coin >= 0 && dp[i - coin] != Int.MAX_VALUE) {
                    dp[i] = minOf(dp[i], dp[i - coin] + 1)
                }
            }
        }

        return if (dp[amount] == Int.MAX_VALUE) -1 else dp[amount]
    }

    // recursive approach
    fun coinChange2(coins: IntArray, amount: Int): Int {
        val memo = IntArray(amount + 1) { -1 } // Memoization array
        return coinChangeHelper(amount, coins, memo)
    }

    private fun coinChangeHelper(amount: Int, coins: IntArray, memo: IntArray): Int {
        if (amount == 0) return 0 // Base case: 0 coins needed for amount 0
        if (amount < 0) return -1 // Not possible to make negative amount

        if (memo[amount] != -1) return memo[amount] // Return cached result

        var minCoins = Int.MAX_VALUE
        for (coin in coins) {
            val res = coinChangeHelper(amount - coin, coins, memo)
            if (res != -1) { // If valid, calculate the minimum
                minCoins = minOf(minCoins, res + 1)
            }
        }

        // If no valid solution, store -1; otherwise, store the minimum coins
        memo[amount] = if (minCoins == Int.MAX_VALUE) -1 else minCoins
        return memo[amount]
    }
}