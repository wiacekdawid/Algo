package `2024_planned`.trees

/**
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 */

// time O(n) / space O(h)
class BinaryTreeInorderTraversal {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        traverseInorder(root, result)
        return result.toList()
    }

    private fun traverseInorder(root: TreeNode?, currentList: MutableList<Int>) {
        root?.let {
            traverseInorder(root.right, currentList)
            currentList.add(root.`val`)
            traverseInorder(root.left, currentList)
        }
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}