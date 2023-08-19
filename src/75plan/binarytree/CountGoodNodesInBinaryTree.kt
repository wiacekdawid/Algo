package `75plan`.binarytree

/**
 * Given a binary tree root, a node X in the tree is named good if in the path
 * from root to X there are no nodes with a value greater than X.
 * Return the number of good nodes in the binary tree.
 */
class CountGoodNodesInBinaryTree {
    // time / space O(n)
    fun goodNodes(root: TreeNode?): Int {
        return root?.let {
            1 + checkNodes(it.left, it.`val`) + checkNodes(it.right, it.`val`)
        } ?: 0

    }

    private fun checkNodes(root: TreeNode?, currentMax: Int) : Int {
        return if (root == null) {
            0
        } else {
            if (root.`val` >= currentMax) {
                1 + checkNodes(root.left, root.`val`) + checkNodes(root.right, root.`val`)
            } else {
                checkNodes(root.left, currentMax) + checkNodes(root.right, currentMax)
            }
        }
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}