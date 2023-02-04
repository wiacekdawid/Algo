package dp.patterns.kadanes

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */

/**
 * time O(n) , space O(1) the best way to understand it is to draw a graph of prices and see peaks
 */
class BestTimeToBuyAndSellStock {
    fun maxProfit(prices: IntArray): Int {
        var maxProfit = 0
        var currentMinPrice = Integer.MAX_VALUE

        prices.forEach {
            if (it < currentMinPrice) {
                currentMinPrice = it
            } else if ((it - currentMinPrice) > maxProfit) {
                maxProfit = it - currentMinPrice
            }
        }

        return maxProfit
    }
}