package `2025`.g.array_strings

/**
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 */
class RotateImage {
    // time O(pow n) / space O(1)
    fun rotate(matrix: Array<IntArray>): Unit {
        val n = matrix.size

        // Step 1: Transpose the matrix
        for (i in 0 until n) {
            for (j in i + 1 until n) {
                val temp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = temp
            }
        }

        // Step 2: Reverse each row
        for (row in matrix) {
            row.reverse()
        }
    }
}