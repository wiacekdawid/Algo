package `75plan`.level1.tree

class MaximumDepthOfBinaryTree {

    /**
     * Given the root of a binary tree, return its maximum depth.
     * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     */

    // time / space O(n)
    fun maxDepth(root: TreeNode?): Int {
        return checkDepth(root, 0)
    }

    private fun checkDepth(root: TreeNode?, currentDepth: Int): Int =
        root?.let {
            checkDepth(root.left, currentDepth + 1)
                .coerceAtLeast(checkDepth(root.right, currentDepth + 1))
        } ?: currentDepth

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}