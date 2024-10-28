package `2024_planned`.trees

/**
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */

// time O(n) / space O(h) - where h is height of tree because of recursive call stack
class MaximumDepthOfBinaryTree {
    fun maxDepth(root: TreeNode?): Int {
        return if (root == null) {
            return 0
        } else {
            1 + maxDepth(root.left).coerceAtLeast(maxDepth(root.right))
        }
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}