package dp.patterns.statereduction

/**
 * You are painting a fence of n posts with k different colors. You must paint the posts following these rules:
 * Every post must be painted exactly one color.
 * There cannot be three or more consecutive posts with the same color.
 * Given the two integers n and k, return the number of ways you can paint the fence.
 */


class PaintFence {

    // top down space/time O(n)
    lateinit var memo: IntArray
    fun numWays(n: Int, k: Int): Int {
        memo = IntArray(n+1) { -1 }

        return dp(n, k)
    }

    private fun dp(currentPost: Int, k : Int): Int {
        if (memo[currentPost] == -1) {
            if (currentPost == 1) {
                memo[currentPost] = k
            }
            else if (currentPost == 2) {
                memo[currentPost] =  k + k * (k-1)
            }
            else {
                memo[currentPost] = (k-1) * (dp(currentPost-1, k) + dp(currentPost-2, k))
            }

        }
        return memo[currentPost]
    }

    // bottom up space / time O(n)
    fun numWays2(n: Int, k: Int): Int {
        val numOfCombinations = IntArray(n) { 0 }

        for (currentPost in 0 until n) {
            when (currentPost) {
                0 -> {
                    numOfCombinations[currentPost] = k
                }
                1 -> {
                    numOfCombinations[currentPost] = k*k
                }
                else -> {
                    numOfCombinations[currentPost] = (k-1) *  (numOfCombinations[currentPost-1] + numOfCombinations[currentPost-2])
                }
            }
        }
        return numOfCombinations[n-1]
    }

    // bottom up space O(1) / time O(n)
    fun numWays3(n: Int, k: Int): Int {
        if (n == 1)
            return k
        if (n == 2)
            return k*k

        var previousTheSame = k
        var previousDifferent = k * (k-1)
        var total = previousDifferent + previousTheSame
        for (currentPost in 2 until n) {
            var theSame = previousDifferent
            var different = (k-1) * (previousTheSame + previousDifferent)
            total = theSame + different
            previousTheSame = theSame
            previousDifferent = different
        }
        return total
    }
}