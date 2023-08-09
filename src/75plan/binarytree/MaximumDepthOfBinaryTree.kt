package `75plan`.binarytree

/**
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along the longest
 * path from the root node down to the farthest leaf node.
 */
class MaximumDepthOfBinaryTree {
    // time O(n) / space O(logn)
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