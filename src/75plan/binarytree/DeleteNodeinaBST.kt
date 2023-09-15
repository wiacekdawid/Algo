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

    /*
  One step right and then always left
  */
    private fun successor(root: TreeNode?): Int {
        var root = root
        root = root!!.right
        while (root!!.left != null) root = root.left
        return root.`val`
    }

    /*
  One step left and then always right
  */
    private fun predecessor(root: TreeNode?): Int {
        var root = root
        root = root!!.left
        while (root!!.right != null) root = root.right
        return root.`val`
    }
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}