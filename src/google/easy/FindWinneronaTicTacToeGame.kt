package google.easy

/**
 * Given a 2D integer array moves where moves[i] = [rowi, coli] indicates that the ith move will be played on grid[rowi][coli].
 * return the winner of the game if it exists (A or B). In case the game ends in a draw return "Draw".
 * If there are still movements to play return "Pending".
 * You can assume that moves is valid (i.e., it follows the rules of Tic-Tac-Toe), the grid is initially empty, and A will play first.
 * time O(m) where m is num of moves / space O(n) where n is length of board
 */

fun main() {
    val test = FindWinneronaTicTacToeGame().tictactoe(arrayOf(intArrayOf(2,2), intArrayOf(0,2), intArrayOf(1,0), intArrayOf(0,1), intArrayOf(2,0),
        intArrayOf(0,0)
    ))
}

class FindWinneronaTicTacToeGame {
    fun tictactoe(moves: Array<IntArray>): String {
        val columns = IntArray(3)
        val rows = IntArray(3)
        var diagonal = 0
        var antiDiagonal = 0
        var player = 1
        moves.forEach { move ->
            rows[move[0]] += player
            columns[move[1]] += player
            if (move[0] == move[1]) {
                diagonal += player
            }
            if (move[0] + move[1] == 2) {
                antiDiagonal += player
            }
            if (columns.any { Math.abs(it) == 3 } ||
                rows.any { Math.abs(it) == 3 } ||
                Math.abs(diagonal) == 3 || Math.abs(antiDiagonal) == 3) {
                return if (player == 1) "A" else "B"
            }
            player *= -1
        }
        return if (moves.size >= 9) "Draw"
        else "Pending"
    }
}