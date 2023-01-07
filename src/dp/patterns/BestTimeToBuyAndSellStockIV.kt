package dp.patterns

/**
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
 * Find the maximum profit you can achieve. You may complete at most k transactions.
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 */

class BestTimeToBuyAndSellStockIV {

    // top down - time and space - O(n*k)
    private lateinit var memo: Array<Array<IntArray>>

    fun maxProfit(k: Int, prices: IntArray): Int {
        memo = Array(prices.size) { Array(k+1) { IntArray(2) { -1 } } }
        return dp(0, k, 0, prices)
    }

    private fun dp(currentPrice: Int, transactionsRemaining: Int, holdingStock: Int, prices: IntArray): Int {

        if (currentPrice >= prices.size || transactionsRemaining == 0) return 0

        if (memo[currentPrice][transactionsRemaining][holdingStock] == -1) {
            val doNothing = dp(currentPrice+1, transactionsRemaining, holdingStock, prices)

            val doSomething = if (holdingStock == 0) {
                dp(currentPrice + 1, transactionsRemaining, 1, prices) - prices[currentPrice]
            } else {
                dp(currentPrice + 1, transactionsRemaining-1, 0, prices) + prices[currentPrice]
            }
            memo[currentPrice][transactionsRemaining][holdingStock] = doNothing.coerceAtLeast(doSomething)
        }

        return memo[currentPrice][transactionsRemaining][holdingStock]
    }

    // top bottom up - time and space - O(n*k)
    fun maxProfit2(k: Int, prices: IntArray): Int {
        val memo = Array(prices.size + 1) { Array(k+1) { IntArray(2) { 0 } } }

        for (currentPrice in prices.size-1 downTo 0) {
            for (transactionRemaining in 1 until k+1) {
                for (holding in 0 until 2) {
                    val doNothing = memo[currentPrice + 1][transactionRemaining][holding]
                    val doSomething = if (holding == 1) {
                        memo[currentPrice + 1][transactionRemaining - 1][0] + prices[currentPrice]
                    } else {
                        memo[currentPrice + 1][transactionRemaining][1] - prices[currentPrice]
                    }
                    memo[currentPrice][transactionRemaining][holding] = doNothing.coerceAtLeast(doSomething)
                }
            }
        }
        return memo[0][k][0]
    }
}