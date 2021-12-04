package treesandgraphs

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * A valid BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * time / space O(n) / O(n)
 */

class ValidateBinarySearchTree {
    fun isValidBST(root: TreeNode?): Boolean {
        return root?.let {
            isValid(it.left, it.`val`, null) &&
                    isValid(it.right, null, it.`val`)
        } ?: true
    }

    private fun isValid(root: TreeNode?, currentMax: Int?, currentMin: Int?): Boolean {
        return root?.let {
            currentMax?.let { root.`val` < it } ?: true &&
                    currentMin?.let { root.`val` > it } ?: true &&
                    isValid(root.left, root.`val`, currentMin) &&
                    isValid(root.right, currentMax, root.`val`)

        } ?: true
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}