package `2024_planned`.trees

/**
 * You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion.
 * It is guaranteed that the new value does not exist in the original BST.
 * Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.
 */

// time / space O(h)
class InsertIntoaBinarySearchTree {
    fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
        if (root == null) return TreeNode(`val`) // Insert as a new leaf node

        // Traverse left or right based on the value
        if (`val` < root.`val`) {
            root.left = insertIntoBST(root.left, `val`)
        } else {
            root.right = insertIntoBST(root.right, `val`)
        }

        return root // Return the unchanged root node
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}