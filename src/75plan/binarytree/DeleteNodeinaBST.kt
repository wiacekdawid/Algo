package `75plan`.binarytree

/**
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
 * Basically, the deletion can be divided into two stages:
 * Search for a node to remove.
 * If the node is found, delete the node.
 */

fun main() {
    val test = DeleteNodeinaBST.TreeNode(2).apply {
        this.right = DeleteNodeinaBST.TreeNode(1)
    }

    val result = DeleteNodeinaBST().deleteNode(test, 2)
    val result1 = result
}
class DeleteNodeinaBST {
    // time O(logN) / space O(tree_height)
    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        if (root == null) return null

        if (key > root.`val`) {
            root.right = deleteNode(root.right, key)
        } else if (key < root.`val`) {
            root.left = deleteNode(root.left, key)
        } else {
            if (root.left == null && root.right == null) {
                root = null
                return null
            } else if (root.right != null) {
                root.`val` = successor(root.right as TreeNode)
                root.right = deleteNode(root.right, root.`val`)
            } else {
                root.`val` = predecessor(root.left as TreeNode)
                root.right = deleteNode(root.right, root.`val`)
            }
        }

        return root
    }

    /**
     * One step left and then always right
     */
    private fun predecessor(currentRootLeft: TreeNode): Int {
        var currentRoot = currentRootLeft
        while (currentRoot.right != null) currentRoot = currentRoot.right as TreeNode
        return currentRoot.`val`
    }

    /**
     * One step right and then always left
     */
    private fun successor(currentRootRight: TreeNode): Int {
        var currentRoot: TreeNode = currentRootRight
        while (currentRoot.left != null) currentRoot = currentRoot.left as TreeNode
        return currentRoot.`val`
    }




    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}