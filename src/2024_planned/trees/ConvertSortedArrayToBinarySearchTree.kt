package `2024_planned`.trees

/**
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
 */
// time / space O(n)
class ConvertSortedArrayToBinarySearchTree {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        return helper(nums, 0, nums.size - 1)
    }

    private fun helper(nums: IntArray, left: Int, right: Int): TreeNode? {
        if (left > right) return null

        // Choose the middle element as the root
        val mid = left + (right - left) / 2
        val root = TreeNode(nums[mid])

        // Recursively build the left and right subtrees
        root.left = helper(nums, left, mid - 1)
        root.right = helper(nums, mid + 1, right)

        return root
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}