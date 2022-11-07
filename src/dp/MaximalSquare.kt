package dp


fun main() {
    val result = MaximalSquare().maximalSquare(arrayOf(charArrayOf('1','1','0','1'),charArrayOf('1','1','0','1'),charArrayOf('1','1','1','1')))
    println(result)
}

class MaximalSquare {

    // top down time/space O(n*m)
    private lateinit var cache: Array<IntArray>

    fun maximalSquare(matrix: Array<CharArray>): Int {
        cache = Array(matrix.size) { IntArray(matrix.first().size) { -1 } }

        dp(0, 0,matrix)

        var maxValue = 0
        cache.forEach {
            it.forEach {
                maxValue = maxValue.coerceAtLeast(it)
            }
        }

        return maxValue * maxValue
    }

    private fun dp(x: Int, y: Int, matrix: Array<CharArray>): Int {
        if (x >= matrix.size || y >= matrix.first().size) {
            return 0
        }

        if (cache[x][y] == -1) {
            val right = dp(x+1, y, matrix)
            val diagonal = dp(x+1, y+1, matrix)
            val left = dp(x, y+1, matrix)
            if (matrix[x][y] == '1') {
                cache[x][y] = 1 + right.coerceAtMost(diagonal).coerceAtMost(left)
            } else {
                cache[x][y] = 0
            }
        }

        return cache[x][y]
    }
}