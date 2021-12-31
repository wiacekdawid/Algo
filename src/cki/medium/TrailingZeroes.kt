package cki.medium

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.
 * time O(logN) / space O(1)
 */

class TrailingZeroes {
    fun trailingZeroes(n: Int): Int {
        var zeroCount = 0;
        var currentMultiple = 5;
        while (n >= currentMultiple) {
            zeroCount += (n / currentMultiple)
            currentMultiple *= 5
        }
        return zeroCount;
    }
}