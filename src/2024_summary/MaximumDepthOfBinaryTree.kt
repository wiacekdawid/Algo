package `2024_summary`

/**
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */

// time / space O(n)
class MaximumDepthOfBinaryTree {
    fun maxDepth(root: TreeNode?): Int {
        fun helper(currentDepth: Int, currentNode: TreeNode?): Int {
            return if (currentNode == null) {
                currentDepth
            } else {
                maxOf(helper(currentDepth+1, currentNode.left),
                helper(currentDepth+1, currentNode.right))
            }
        }
        return helper(0, root)
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}