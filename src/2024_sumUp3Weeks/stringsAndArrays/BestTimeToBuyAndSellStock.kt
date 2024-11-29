package `2024_sumUp3Weeks`.stringsAndArrays

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */

// time O(n) / space O(1)
class BestTimeToBuyAndSellStock {
    fun maxProfit(prices: IntArray): Int {
        if (prices.size <= 1) return 0 // Handle edge cases

        var maxProfit = 0
        var currentMin = Int.MAX_VALUE

        prices.forEach { price ->
            currentMin = currentMin.coerceAtMost(price) // Update the minimum price so far
            maxProfit = maxProfit.coerceAtLeast(price - currentMin) // Calculate max profit
        }

        return maxProfit
    }
}