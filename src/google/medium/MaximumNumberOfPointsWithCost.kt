package google.medium

/**
 * You are given an m x n integer matrix points (0-indexed). Starting with 0 points, you want to maximize the number of points you can get from the matrix.
 * To gain points, you must pick one cell in each row. Picking the cell at coordinates (r, c) will add points[r][c] to your score.
 * However, you will lose points if you pick a cell too far from the cell that you picked in the previous row.
 * For every two adjacent rows r and r + 1 (where 0 <= r < m - 1), picking cells at coordinates (r, c1) and (r + 1, c2) will subtract abs(c1 - c2) from your score.
 * Return the maximum number of points you can achieve.
 * abs(x) is defined as:
 * x for x >= 0.
 * -x for x < 0.
 * time O(m*n) / space O(1)
 */
class MaximumNumberOfPointsWithCost {
    fun maxPoints(points: Array<IntArray>): Long {
        val m = points.size
        val n = points[0].size

        var pre = LongArray(size = n)
        points[0].forEachIndexed { index, i ->
            pre[index] = i.toLong()
        }

        for (i in 0  until m-1) {
            val left = LongArray(n)
            val right = LongArray(n)
            val current = LongArray(n)

            left[0] = pre[0]
            right[n-1] = pre[n-1]

            for (j in 1 until n) {
                left[j] = Math.max(left[j-1]-1, pre[j])
            }

            for (j in n-2 downTo 0) {
                right[j] = Math.max(right[j+1]-1, pre[j])
            }

            for (j in 0 until n) {
                current[j] = points[i+1][j] + Math.max(left[j], right[j])
            }
            pre = current
        }

        var answer: Long = 0L
        pre.forEach {
            answer = Math.max(it, answer)
        }

        return answer
    }
}