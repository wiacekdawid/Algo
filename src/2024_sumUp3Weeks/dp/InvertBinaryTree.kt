package `2024_sumUp3Weeks`.dp

import java.util.ArrayDeque

/**
 * Given the root of a binary tree, invert the tree, and return its root.
 */

class InvertBinaryTree {
    // time O(n) / space O(width)
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return null

        val queue = ArrayDeque<TreeNode>()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val current = queue.poll()

            // Swap the left and right children
            val temp = current.left
            current.left = current.right
            current.right = temp

            // Add the children to the queue if they exist
            current.left?.let { queue.add(it) }
            current.right?.let { queue.add(it) }
        }

        return root
    }

    // time O(n) / space O(h)
    fun invertTree2(root: TreeNode?): TreeNode? {
        if (root == null) return null

        // Swap left and right subtrees
        val temp = root.left
        root.left = invertTree(root.right)
        root.right = invertTree(temp)

        return root
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}