package treesandgraphs

/**
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 * time/space O(n)
 * could be also done with the help of the Stack
 */

class KthSmallestElementInABST {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        val nums = inorder(root, ArrayList())
        return nums[k - 1]
    }

    private fun inorder(root: TreeNode?, arr: ArrayList<Int>): ArrayList<Int> {
        if (root == null) return arr
        inorder(root.left, arr)
        arr.add(root.`val`)
        inorder(root.right, arr)
        return arr
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}