package dp.more

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.
 * Find the maximum profit you can achieve. You may complete as many transactions as you like,
 * but you need to pay the transaction fee for each transaction.
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 */
class BestTimeToBuyAndSellStockWithTransactionFee {

    // top down - time and space - O(n)
    private lateinit var memo: Array<IntArray>

    fun maxProfit(prices: IntArray, fee: Int): Int {
        memo = Array(prices.size) { IntArray(2) { -1 } }
        return dp(0,0, prices, fee)
    }

    private fun dp(currentPrice: Int, holdingStock: Int, prices: IntArray, fee: Int): Int {

        if (currentPrice >= prices.size) return 0

        if (memo[currentPrice][holdingStock] == -1) {
            val doNothing = dp(currentPrice+1, holdingStock, prices, fee)

            val doSomething = if (holdingStock == 0) {
                dp(currentPrice + 1, 1, prices, fee) - prices[currentPrice]
            } else {
                dp(currentPrice + 1, 0, prices, fee) + prices[currentPrice] - fee
            }
            memo[currentPrice][holdingStock] = doNothing.coerceAtLeast(doSomething)
        }

        return memo[currentPrice][holdingStock]
    }

    // bottom up - time and space - O(n)
    fun maxProfit2(prices: IntArray, fee: Int): Int {
        var memo = Array(prices.size+1) { IntArray(2) { 0 } }

        for (currentPriceIndex in prices.size-1 downTo 0) {
            for (holdingStock in 0 until 2) {
                val doNothing = memo[currentPriceIndex+1][holdingStock]

                val doSomething = if (holdingStock == 0) {
                    memo[currentPriceIndex+1][holdingStock] - prices[currentPriceIndex]
                } else {
                    memo[currentPriceIndex+1][holdingStock] + prices[currentPriceIndex] - fee
                }
                memo[currentPriceIndex][holdingStock] = doNothing.coerceAtLeast(doSomething)
            }
        }
        return memo[0][0]
    }
}