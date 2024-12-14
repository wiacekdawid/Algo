package `2024_sumUp3Weeks`.dp

import kotlin.math.abs

/**
 * Given a binary tree, determine if it is height-balanced.
 */

// time O(n) / space O(h)
class BalancedBinaryTree {
    fun isBalanced(root: TreeNode?): Boolean {
        fun height(node: TreeNode?): Int {
            if (node == null) return 0

            val leftHeight = height(node.left)
            if (leftHeight == -1) return -1 // Left subtree is unbalanced

            val rightHeight = height(node.right)
            if (rightHeight == -1) return -1 // Right subtree is unbalanced

            if (abs(leftHeight - rightHeight) > 1) return -1 // Current node is unbalanced

            return maxOf(leftHeight, rightHeight) + 1 // Return height of the current subtree
        }

        return height(root) != -1
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}