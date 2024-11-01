package `2024_planned`.trees

/**
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 */

// time O(n) / space O(h)
class KthSmallestElementInaBST {

    class ResultWrapper(var count: Int = 0, var result: Int? = null)

    fun kthSmallest(root: TreeNode?, k: Int): Int {
        val wrapper = ResultWrapper()
        inOrderTraversal(root, k, wrapper)
        return wrapper.result ?: -1 // Return -1 if not found
    }

    private fun inOrderTraversal(node: TreeNode?, k: Int, wrapper: ResultWrapper) {
        if (node == null || wrapper.count >= k) return

        inOrderTraversal(node.left, k, wrapper)

        wrapper.count++
        if (wrapper.count == k) {
            wrapper.result = node.`val`
            return
        }

        inOrderTraversal(node.right, k, wrapper)
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}