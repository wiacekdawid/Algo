package `75plan`.binarytree

/**
 * You are given the root of a binary search tree (BST) and an integer val.
 * Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.
 */

class SearchInABinarySearchTree {
    // Time complexity : O(h) where h is a tree height. That results in
    // O(logN) in the average case, and O(N) in the worst case
    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
        return if (root == null) {
            null
        } else {
            if (root.`val` == `val`) {
                root
            } else if (root.`val` > `val`) {
                searchBST(root.left, `val`)
            } else {
                searchBST(root.right, `val`)
            }
        }
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}