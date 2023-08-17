package `75plan`.binarytree

import java.util.*

/**
 * Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.
 */
class LeafSimilarTrees {

    // time/space O(l1 + l2)
    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        val list1 = mutableListOf<Int>()
        val list2 = mutableListOf<Int>()
        getLeafList(root1, list1)
        getLeafList(root2, list2)
        return list1 == list2
    }

    private fun getLeafList(root: TreeNode?, currentList: MutableList<Int>) {
        if (root != null && root.left == null && root.right == null) {
            currentList.add(root.`val`)
        } else {
            root?.left?.let { getLeafList(it, currentList) }
            root?.right?.let { getLeafList(it, currentList) }
        }
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}