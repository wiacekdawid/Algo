package `2024_sumUp3Weeks`.dp

/**
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them.
 * A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 * The path sum of a path is the sum of the node's values in the path.
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 */

// time O(n) / space O(h)
class BinaryTreeMaximumPathSum {
    fun maxPathSum(root: TreeNode?): Int {
        var maxGain = Int.MIN_VALUE
        fun helper(node: TreeNode?): Int {
            if (node == null) return 0

            val leftGain = maxOf(helper(node.left), 0)
            val rightGain = maxOf(helper(node.right), 0)

            val currentMaxPath = node.`val` + leftGain + rightGain

            maxGain = maxGain.coerceAtLeast(currentMaxPath)

            return node.`val` + leftGain.coerceAtLeast(rightGain)
        }
        helper(root)

        return maxGain
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}