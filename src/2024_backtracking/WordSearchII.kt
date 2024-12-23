package `2024_backtracking`

/**
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once in a word.
 */

class WordSearchII {
    // time O(LxW + MxNx4powL) / space O(LxW + MxN + L) where L word length / M/N board size / W total num of words
    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {

        if (board.isEmpty() || words.isEmpty()) return emptyList()

        val result = mutableSetOf<String>() // Use a set to avoid duplicates
        val trie = Trie()

        // Build the Trie from the word list
        for (word in words) {
            trie.insert(word)
        }

        val rows = board.size
        val cols = board[0].size
        val used = Array(rows) { BooleanArray(cols) } // Reusable visited array

        fun backtrack(row: Int, col: Int, node: TrieNode, path: StringBuilder) {
            // Out of bounds or already visited
            if (row < 0 || row >= rows || col < 0 || col >= cols || used[row][col]) return

            val char = board[row][col]
            val nextNode = node.children[char] ?: return // If char not in Trie, stop

            // Add the character to the current path
            path.append(char)
            used[row][col] = true

            // If this path forms a valid word, add it to the result
            if (nextNode.isWord) {
                result.add(path.toString())
            }

            // Explore neighbors
            backtrack(row + 1, col, nextNode, path)
            backtrack(row - 1, col, nextNode, path)
            backtrack(row, col + 1, nextNode, path)
            backtrack(row, col - 1, nextNode, path)

            // Backtrack: Reset state
            path.deleteCharAt(path.length - 1)
            used[row][col] = false
        }

        // Start backtracking from every cell
        for (row in board.indices) {
            for (col in board[0].indices) {
                backtrack(row, col, trie.root, StringBuilder())
            }
        }

        return result.toList()
    }

    class TrieNode {
        val children = mutableMapOf<Char, TrieNode>()
        var isWord = false
    }

    class Trie {
        val root = TrieNode()

        fun insert(word: String) {
            var node = root
            for (char in word) {
                node = node.children.getOrPut(char) { TrieNode() }
            }
            node.isWord = true
        }
    }
}