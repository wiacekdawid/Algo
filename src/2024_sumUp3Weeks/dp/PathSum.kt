package `2024_sumUp3Weeks`.dp

/**
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
 * A leaf is a node with no children.
 */

// time O(n) / space O(h)
class PathSum {
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        fun helper(currentSum: Int, node: TreeNode?): Boolean {
            if (node == null) return false
            val newSum = currentSum + node.`val`
            if (newSum == targetSum && node.left == null && node.right == null)
                return true
            return helper(newSum, node.left) || helper(newSum, node.right)
        }
        return helper(0, root)
    }

    fun hasPathSum2(root: TreeNode?, targetSum: Int): Boolean {
        if (root == null) return false
        if (root.left == null && root.right == null) {
            return targetSum == root.`val`
        }
        val newTarget = targetSum - root.`val`
        return hasPathSum(root.left, newTarget) || hasPathSum(root.right, newTarget)
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}