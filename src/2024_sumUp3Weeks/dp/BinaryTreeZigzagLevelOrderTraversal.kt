package `2024_sumUp3Weeks`.dp

import java.util.ArrayDeque

/**
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
 */

// time / space O(n)
class BinaryTreeZigzagLevelOrderTraversal {

    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()

        val output = mutableListOf<List<Int>>()
        val queue = ArrayDeque<TreeNode>()
        queue.add(root)
        var currentOrder = true

        while (queue.isNotEmpty()) {
            val currentLevelSize = queue.size
            val currentList = mutableListOf<Int>()

            for (i in 0 until currentLevelSize) {
                val currentNode = queue.poll()
                if (currentOrder) {
                    currentList.add(currentNode.`val`)
                } else {
                    currentList.add(0, currentNode.`val`) // Add to the front for reverse order
                }

                currentNode.left?.let { queue.add(it) }
                currentNode.right?.let { queue.add(it) }
            }

            output.add(currentList)
            currentOrder = !currentOrder
        }

        return output
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}