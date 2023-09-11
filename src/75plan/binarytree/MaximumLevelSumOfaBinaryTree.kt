package `75plan`.binarytree

import java.util.*

/**
 * Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
 * Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
 */

class MaximumLevelSumOfaBinaryTree {
    // time/space O(n)
    fun maxLevelSum(root: TreeNode?): Int {
        val queue = LinkedList<TreeNode>()
        root?.let { queue.add(root) }

        var currentLevel = 1
        var maxLevel = currentLevel
        var maxSumInLevel = Integer.MIN_VALUE
        while (queue.isNotEmpty()) {
            val currentSize = queue.size
            var currentSum = 0
            for (i in currentSize downTo 1) {
                val currentNode = queue.poll()
                currentSum += currentNode.`val`
                currentNode.left?.let { queue.add(it) }
                currentNode.right?.let { queue.add(it) }
            }

            if (currentSum > maxSumInLevel) {
                maxSumInLevel = currentSum
                maxLevel = currentLevel
            }
            currentLevel++
        }

        return maxLevel
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}