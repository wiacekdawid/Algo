package `2025`.refreshMarch

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */

class BestTimeToBuyAndSellStock {
    // time O(n) / space O(1)
    fun maxProfit(prices: IntArray): Int {
        var maxProfit = 0
        var minBuy = Int.MAX_VALUE

        prices.forEach {
            maxProfit = maxProfit.coerceAtLeast(it - minBuy)
            minBuy = minBuy.coerceAtMost(it)
        }

        return maxProfit
    }
}