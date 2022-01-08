package treesandgraphs

/**
 * Given the root of a binary tree, collect a tree's nodes as if you were doing this:
 * Collect all the leaf nodes
 * Remove all the leaf nodes.
 * Repeat until the tree is empty.
 */
class FindLeavesOfBinaryTree {
    // solution #1 DFS using height of leaves space O(N) time O(N)
    fun findLeaves2(root: TreeNode?): List<List<Int>> {
        val solution = mutableListOf<MutableList<Int>>()
        getHeight(root, solution)
        return solution
    }

    private fun getHeight(root: TreeNode?, solution: MutableList<MutableList<Int>>): Int {
        return if (root == null) {
            -1
        } else {
            val leftHeight = root.left?.let { getHeight(it, solution) } ?: -1
            val rightHeight = root.right?.let { getHeight(it, solution) } ?: -1

            val currentHeight = leftHeight.coerceAtLeast(rightHeight) + 1

            if (solution.size == currentHeight) {
                solution.add(mutableListOf())
            }

            solution[currentHeight].add(root.`val`)

            currentHeight
        }
    }

    // solution #2 DFS space O(N) time O(2powN)
    fun findLeaves(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()
        if (root == null) return emptyList()
        var shouldContinue = true
        while (shouldContinue) {
            val subList = mutableListOf<Int>()
            if (getLeavesAndCheckIfChildrenAreLeaves(root, subList)) {
                shouldContinue = false
            }
            result.add(subList)
        }
        return result
    }

    private fun getLeavesAndCheckIfChildrenAreLeaves(root: TreeNode, currentList: MutableList<Int>): Boolean {
        return if (root.left == null && root.right == null) {
            currentList.add(root.`val`)
            true
        } else {
            var leftChildIsLeave = false
            var rightChildIsLeave = false
            root.left?.let {
                leftChildIsLeave = getLeavesAndCheckIfChildrenAreLeaves(it, currentList)
            }
            root.right?.let {
                rightChildIsLeave = getLeavesAndCheckIfChildrenAreLeaves(it, currentList)
            }
            if (leftChildIsLeave) {
                root.left = null
            }
            if (rightChildIsLeave) {
                root.right = null
            }
            false
        }
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}