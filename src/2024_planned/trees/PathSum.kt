package `2024_planned`.trees

/**
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
 * A leaf is a node with no children.
 */

// time / space O(n)
class PathSum {

    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        return helper(root, 0, targetSum)
    }

    private fun helper(root: TreeNode?, currentSum: Int, targetSum: Int): Boolean {
        // Base case: if the node is null, there’s no path to check
        if (root == null) return false

        // Update the current path sum by adding the current node’s value
        val newSum = currentSum + root.`val`

        // Check if we are at a leaf node and if the path sum equals targetSum
        if (root.left == null && root.right == null) {
            return newSum == targetSum
        }

        // Recursively check the left and right subtrees
        return helper(root.left, newSum, targetSum) || helper(root.right, newSum, targetSum)
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}