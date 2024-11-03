package `2024_planned`.trees

import kotlin.math.abs

/**
 * Given a binary tree, determine if it is height-balanced.
 */

// time O(n) / space O(h)
class BalancedBinaryTree {
    fun isBalanced(root: TreeNode?): Boolean {
        return checkHeight(root) != -1
    }

    private fun checkHeight(node: TreeNode?): Int {
        if (node == null) return 0

        val leftHeight = checkHeight(node.left)
        if (leftHeight == -1) return -1 // Left subtree is not balanced

        val rightHeight = checkHeight(node.right)
        if (rightHeight == -1) return -1 // Right subtree is not balanced

        if (abs(leftHeight - rightHeight) > 1) return -1 // Current node is not balanced

        // Return the height of the current node
        return 1 + maxOf(leftHeight, rightHeight)
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}