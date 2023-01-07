package dp.patterns

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * Find the maximum profit you can achieve. You may complete as many transactions as you like
 * (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
 * After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 */
class BestTimeToBuyAndSellStockWithCooldown {

    // top down - time and space - O(n*k)
    private lateinit var memo: Array<Array<IntArray>>

    fun maxProfit(prices: IntArray): Int {
        memo = Array(prices.size) { Array(2) { IntArray(2) { -1 } } }
        return dp(0, 0, 0, prices)
    }

    private fun dp(currentPrice: Int, previousDaySellStock: Int, holdingStock: Int, prices: IntArray): Int {

        if (currentPrice >= prices.size) return 0

        if (memo[currentPrice][previousDaySellStock][holdingStock] == -1) {
            if (previousDaySellStock == 1) {
                memo[currentPrice][previousDaySellStock][holdingStock] =
                    dp(currentPrice+1, 0, 0, prices)
            } else {
                val doNothing = dp(currentPrice + 1, previousDaySellStock, holdingStock, prices)

                val doSomething =
                    if (holdingStock == 1) {
                        dp(currentPrice + 1, 1, 0, prices) + prices[currentPrice]
                    } else {
                        dp(currentPrice + 1, 0, 1, prices) - prices[currentPrice]
                    }
                memo[currentPrice][previousDaySellStock][holdingStock] = doNothing.coerceAtLeast(doSomething)
            }
        }

        return memo[currentPrice][previousDaySellStock][holdingStock]
    }
}