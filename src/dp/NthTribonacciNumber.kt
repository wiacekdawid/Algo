package dp

/**
 * The Tribonacci sequence Tn is defined as follows:
 * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 * Given n, return the value of Tn.
 * we know that n < 38
 * can be two approaches 1 with precompute all 38 num and store them, and later get them with O(1) time
 * or do dynamic programming, we can also just keep last 3 num during dp
 */

class NthTribonacciNumber {
    /**
     * 3 numbers
     */
    fun tribonacci(n: Int): Int {
        if (n < 3) return if (n == 0) 0 else 1
        var tmp: Int
        var x = 0
        var y = 1
        var z = 1
        for (i in 3..n) {
            tmp = x + y + z
            x = y
            y = z
            z = tmp
        }
        return z
    }
    /**
     * top down
     */
    private val map = HashMap<Int, Int>()

    fun tribonacci2(n: Int): Int {
        return dp(n)
    }

    private fun dp(i: Int): Int {
        if (i == 0) return 0
        if (i == 1) return 1
        if (i == 2) return 1
        if (!map.containsKey(i)) {
            map[i] = dp(i-1) + dp(i-2) + dp(i-3)
        }
        return map[i] ?: 0
    }

    /**
     * bottom up
     */
    fun tribonacci3(n: Int): Int {
        if (n < 3) return if (n == 0) 0 else 1
        val array = IntArray(n+1)
        array[0] = 0
        array[1] = 1
        array[2] = 1
        for (i in 0 until n) {
            array[i] = array[i-1] + array[i-2] + array[i-3]
        }
        return array[n]
    }
}