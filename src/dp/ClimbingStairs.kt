package dp

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */

class ClimbingStairs {
    /**
     * top down with memoizaiton (time complexity O(n)
     */
    private val map = mutableMapOf<Int, Int>()

    fun climbStairs(n: Int): Int {
        return dp(n)
    }

    private fun dp(i: Int): Int {
        if (i <= 2) return i
        if (!map.containsKey(i)) {
            map[i] = dp(i-1) + dp(i-2)
        }
        return map[i] ?: 0
    }
    /**
     * bottom up
     */
    fun climbStairs2(n: Int): Int {
        if (n <= 2) return n
        val array = IntArray(n+1)
        array[1] = 1
        array[2] = 2
        for (i in 3 until n+1) {
            array[i] = array[i-1] + array[i-2]
        }
        return array[n]
    }
}