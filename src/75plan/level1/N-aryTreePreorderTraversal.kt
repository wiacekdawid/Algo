package `75plan`.level1

/**
 * Given the root of an n-ary tree, return the preorder traversal of its nodes' values.
 * Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)
 */
class `N-aryTreePreorderTraversal` {

    fun preorder(root: Node?): List<Int> {
        val mutableList = mutableListOf<Int>()

        return mutableList
    }

    class Node(var `val`: Int) {
        var children: List<Node?> = listOf()
    }
}