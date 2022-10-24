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
     * top down
     */
    val tribonacciMap = mutableMapOf<Int, Int>()

    fun tribonacci(n: Int): Int {
        if (n == 0) return 0
        if (n == 1 || n == 2) return 1
        if (!tribonacciMap.containsKey(n)) {
            tribonacciMap[n] = tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3)
        }
        return tribonacciMap[n] ?: 0
    }

    /**
     * 3 numbers optimase space - keeping only last 3 numbers
     */
    fun tribonacci3(n: Int): Int {
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
     * bottom up
     */
    fun tribonacci2(n: Int): Int {
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