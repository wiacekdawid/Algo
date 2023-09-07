package `75plan`.binarytree

import java.util.*

/**
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 */
class BinaryTreeRightSideView {
    // time O(n) / space O(diameter of tree)
    fun rightSideView(root: TreeNode?): List<Int> {
        val outputList = mutableListOf<Int>()
        val listOfNodes = LinkedList<TreeNode>()
        root?.let { listOfNodes.add(it) }
        while(listOfNodes.isNotEmpty()) {
            val numOfElements = listOfNodes.size
            for (i in 0 until numOfElements) {
                val currentTree = listOfNodes.poll()
                if (i == numOfElements-1) {
                    outputList.add(currentTree.`val`)
                }
                currentTree?.left?.let { listOfNodes.add(it) }
                currentTree?.right?.let { listOfNodes.add(it) }
            }
        }
        return outputList.toList()
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}