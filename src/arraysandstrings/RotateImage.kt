package arraysandstrings

/**
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 * time O(M) space O(1) where M is num of cells in the grid
 */

class RotateImage {
    fun rotate(matrix: Array<IntArray>) {
        transpose(matrix)
        reflect(matrix)
    }

    private fun transpose(matrix: Array<IntArray>) {
        val n = matrix.size
        for(i in 0 until n) {
            for (j in i+1 until n) {
                val temp = matrix[j][i]
                matrix[j][i] = matrix[i][j]
                matrix[i][j] = temp
            }
        }
    }

    private fun reflect(matrix: Array<IntArray>) {
        val n = matrix.size
        for(i in 0 until n) {
            for (j in 0 until n/2) {
                val temp = matrix[i][j]
                matrix[i][j] = matrix[i][n-j-1]
                matrix[i][n-j-1] = temp
            }
        }
    }
}