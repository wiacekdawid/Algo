package `75plan`.binarytree

import java.util.*

/**
 * Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.
 */
class LeafSimilarTrees {

    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        return getLeafList(root1) == getLeafList(root2)
    }

    private fun getLeafList(root: TreeNode?): List<Int> {
        val list = mutableListOf<Int>()

        val currentList = LinkedList<TreeNode>()
        root?.let { currentList.add(it) }

        while (currentList.isNotEmpty()) {
            val currentNode = currentList.pop()
            if (currentNode.left == null && currentNode.right == null) {
                list.add(currentNode.`val`)
            } else {
                currentNode.left?.let { currentList.add(it) }
                currentNode.right?.let { currentList.add(it) }
            }
        }
        return list.toList()
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}