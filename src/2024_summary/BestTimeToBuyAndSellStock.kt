package `2024_summary`

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */

class BestTimeToBuyAndSellStock {
    // time O(n) / space O(1)
    fun maxProfit(prices: IntArray): Int {
        var maxProfit = 0
        var currentMin = Int.MAX_VALUE

        for (currentIndex in prices.indices) {
            maxProfit = maxProfit.coerceAtLeast(prices[currentIndex] - currentMin)
            currentMin = currentMin.coerceAtMost(prices[currentIndex])
        }

        return maxProfit
    }
}