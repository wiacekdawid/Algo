package `2024_planned`.trees

import java.util.*

/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 */

// time O(n) / space O(h)
class SymmetricTree {
    fun isSymmetric(root: TreeNode?): Boolean {
        return root == null || isMirror(root.left, root.right)
    }

    private fun isMirror(left: TreeNode?, right: TreeNode?): Boolean {
        if (left == null && right == null) return true
        if (left == null || right == null) return false
        return (left.`val` == right.`val`) &&
                isMirror(left.left, right.right) &&
                isMirror(left.right, right.left)
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}