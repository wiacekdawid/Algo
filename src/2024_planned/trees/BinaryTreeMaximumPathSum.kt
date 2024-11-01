package `2024_planned`.trees

/**
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them.
 * A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 * The path sum of a path is the sum of the node's values in the path.
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 */

// time / space O(n)
class BinaryTreeMaximumPathSum {

    fun maxPathSum(root: TreeNode?): Int {
        var maxSum = Int.MIN_VALUE

        fun maxGain(node: TreeNode?): Int {
            if (node == null) return 0

            // Compute the maximum path sum for left and right subtrees, ignoring negative sums
            val leftGain = maxOf(maxGain(node.left), 0)
            val rightGain = maxOf(maxGain(node.right), 0)

            // Calculate the path sum that passes through this node
            val currentMaxPath = node.`val` + leftGain + rightGain

            // Update the global maximum path sum
            maxSum = maxOf(maxSum, currentMaxPath)

            // Return the maximum path sum that can be extended to this node's parent
            return node.`val` + maxOf(leftGain, rightGain)
        }

        maxGain(root)
        return maxSum
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}