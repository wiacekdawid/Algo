package `2024_planned`.trees

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * A valid BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */

// time / space O(n)
class ValidateBinarySearchTree {
    fun isValidBST(root: TreeNode?): Boolean {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE)
    }

    private fun isValidBST(node: TreeNode?, min: Long, max: Long): Boolean {
        if (node == null) {
            return true
        }
        if (node.`val` <= min || node.`val` >= max) {
            return false
        }
        return isValidBST(node.left, min, node.`val`.toLong()) &&
                isValidBST(node.right, node.`val`.toLong(), max)
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}