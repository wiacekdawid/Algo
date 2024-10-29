package `2024_planned`.trees

import java.util.*

/**
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 */

// time O(n) / space O(n)
class BinaryTreeLevelOrderTraversal {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        val currentStack = LinkedList<TreeNode>()
        root?.let { currentStack.add(root) }

        while(currentStack.isNotEmpty()) {
            var currentSize = currentStack.size
            val currentList = mutableListOf<Int>()
            while (currentSize > 0) {
                val currentNode = currentStack.pop()
                currentList.add(currentNode.`val`)
                currentSize--
                currentNode.left?.let { currentStack.add(it) }
                currentNode.right?.let { currentStack.add(it) }
            }
            result.add(currentList)
        }

        return result.toList()
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}