package dp.patterns

/**
 * You are given an integer array coins representing coins of different denominations and an integer
 * amount representing a total amount of money.
 * Return the fewest number of coins that you need to make up that amount. If that amount of
 * money cannot be made up by any combination of the coins, return -1.
 * You may assume that you have an infinite number of each kind of coin.
 */
class CoinChange {

    /**
     * top down - time O(S*n) where S is amount, n denomination count / space O(S)
     */
    fun coinChange(coins: IntArray, amount: Int): Int {
        if (amount < 1) return 0
        return dp(coins, amount, IntArray(amount))

    }

    private fun dp(coins: IntArray, remainAmount: Int, count: IntArray): Int {
        if (remainAmount < 0) return -1
        if (remainAmount == 0) return 0
        if (count[remainAmount - 1] != 0) return count[remainAmount-1]

        var min = Int.MAX_VALUE

        coins.forEach { coin ->
            val res = dp(coins, remainAmount - coin, count)
            if (res in 0 until min) {
                min = 1 + res
            }
        }

        count[remainAmount-1] = if (min == Int.MAX_VALUE) -1 else min

        return count[remainAmount-1]
    }
}