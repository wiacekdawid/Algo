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
                memo[currentPost] =  k * k
            }
            else {
                memo[currentPost] = (k-1) * (dp(currentPost-1, k) + dp(currentPost-2, k))
            }

        }

        return memo[currentPost]
    }
}