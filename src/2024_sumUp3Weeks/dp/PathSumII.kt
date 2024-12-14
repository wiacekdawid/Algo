package `2024_sumUp3Weeks`.dp

/**
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum.
 * Each path should be returned as a list of the node values, not node references.
 * A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
 */

// time O(n) / space O(h)
class PathSumII {
    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        fun helper(node: TreeNode?, currentList: MutableList<Int>, currentSum: Int) {
            if (node == null) return

            // Add the current node to the path
            currentList.add(node.`val`)
            val newSum = currentSum + node.`val`

            // If it's a leaf and the sum matches, add the path to the result
            if (node.left == null && node.right == null && newSum == targetSum) {
                result.add(ArrayList(currentList)) // Make a copy of the current path
            } else {
                // Recur for left and right children
                helper(node.left, currentList, newSum)
                helper(node.right, currentList, newSum)
            }

            // Backtrack to remove the current node from the path
            currentList.removeAt(currentList.size - 1)
        }

        helper(root, mutableListOf(), 0)
        return result
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}