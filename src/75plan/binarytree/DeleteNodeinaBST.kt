package `75plan`.binarytree

/**
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
 * Basically, the deletion can be divided into two stages:
 * Search for a node to remove.
 * If the node is found, delete the node.
 */

class DeleteNodeinaBST {
    // time O(logN) / space O(tree_height)
    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        val currentRoot = root
        if (currentRoot == null) {
            return null
        } else {
            if (key > currentRoot.`val`) {
                currentRoot.right = deleteNode(currentRoot.right, key)
            } else if (key < root.`val`) {
                currentRoot.left = deleteNode(currentRoot.left, key)
            } else {
                if (currentRoot.left == null && currentRoot.right == null) {
                    return null
                } else if (currentRoot.right != null) {
                    currentRoot.`val` = successor(currentRoot)
                    currentRoot.right = deleteNode(currentRoot.right, currentRoot.`val`)
                } else {
                    currentRoot.`val` = predecessor(currentRoot)
                    currentRoot.right = deleteNode(currentRoot.right, currentRoot.`val`)
                }
            }
        }
        return currentRoot
    }

    /*
  One step right and then always left
  */
    private fun successor(root: TreeNode): Int {
        var currentRoot: TreeNode? = root
        currentRoot = currentRoot?.right
        while (currentRoot?.left != null) currentRoot = currentRoot.left
        return currentRoot!!.`val`
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