package `75plan`.level1

import java.util.*

/**
 * Given the root of an n-ary tree, return the preorder traversal of its nodes' values.
 * Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)
 */
class `N-aryTreePreorderTraversal` {

    // time / space O(n)
    fun preorder(root: Node?): List<Int> {
        val mutableList = mutableListOf<Int>()
        goDeep(root, mutableList)

        return mutableList
    }

    private fun goDeep(root: Node?, mutableList: MutableList<Int>) {
        root?.let {  root ->
            mutableList.add(root.`val`)

            root.children.forEach { child ->
                goDeep(child, mutableList)
            }
        }
    }

    class Node(var `val`: Int) {
        var children: List<Node?> = listOf()
    }
}