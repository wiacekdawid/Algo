package `2024_sumUp3Weeks`.dp

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * A valid BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */

// time O(n) / space O(h)
class ValidateBinarySearchTree {
    fun isValidBST(root: TreeNode?): Boolean {
        fun helper(node: TreeNode?, min: Int?, max: Int?): Boolean {
            if (node == null) return true // An empty tree is a valid BST

            val value = node.`val`

            // Check if the current node violates the min/max constraints
            if ((min != null && value <= min) || (max != null && value >= max)) {
                return false
            }

            // Recursively validate the left and right subtrees
            return helper(node.left, min, value) && helper(node.right, value, max)
        }

        return helper(root, null, null) // Initially, there are no constraints
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}