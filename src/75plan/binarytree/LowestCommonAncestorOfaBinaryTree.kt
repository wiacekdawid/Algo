package `75plan`.binarytree

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q
 * as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 */
class LowestCommonAncestorOfaBinaryTree {
    private var result: TreeNode? = null
    // time/space O(n)
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        recurseTree(root, p, q)
        return result
    }

    private fun recurseTree(root: TreeNode?, p: TreeNode?, q: TreeNode?): Boolean {
        if (root == null) return false

        val left = if (recurseTree(root.left, p, q)) 1 else 0
        val right = if (recurseTree(root.right, p, q)) 1 else 0
        val mid = if (root == p || root == q) 1 else 0

        if (mid + left + right >= 2) {
            result = root
        }

        return (mid + left + right) > 0
    }

    class TreeNode(var `val`: Int = 0) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}