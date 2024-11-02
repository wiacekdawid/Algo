package `2024_planned`.trees

/**
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
 * Basically, the deletion can be divided into two stages:
 * Search for a node to remove.
 * If the node is found, delete the node.
 */

// time / space O(h)
class DeleteNodeInaBST {
    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        if (root == null) return null

        // Search for the node to delete
        when {
            key < root.`val` -> {
                root.left = deleteNode(root.left, key)
            }
            key > root.`val` -> {
                root.right = deleteNode(root.right, key)
            }
            else -> { // Node with `key` found
                // Case 1: Node with only one child or no child
                if (root.left == null) return root.right
                if (root.right == null) return root.left

                // Case 2: Node with two children
                // Find the in-order successor (smallest in the right subtree)
                val minLargerNode = findMin(root.right)
                root.`val` = minLargerNode!!.`val` // Replace value with successor
                root.right = deleteNode(root.right, root.`val`) // Delete successor
            }
        }

        return root
    }

    private fun findMin(node: TreeNode?): TreeNode? {
        var current = node
        while (current?.left != null) {
            current = current.left
        }
        return current
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}