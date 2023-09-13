package `75plan`.binarytree

/**
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
 * Basically, the deletion can be divided into two stages:
 * Search for a node to remove.
 * If the node is found, delete the node.
 */

class DeleteNodeinaBST {
    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        if (root == null) {
            return root
        } else {
            if (root.`val` == key) {

            }
        }
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}