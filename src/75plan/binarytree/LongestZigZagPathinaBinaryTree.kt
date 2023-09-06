package `75plan`.binarytree

/**
 * You are given the root of a binary tree.
 * A ZigZag path for a binary tree is defined as follow:
 * Choose any node in the binary tree and a direction (right or left).
 * If the current direction is right, move to the right child of the current node; otherwise, move to the left child.
 * Change the direction from right to left or from left to right.
 * Repeat the second and third steps until you can't move in the tree
 * Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).
 * Return the longest ZigZag path contained in that tree.
 */

class LongestZigZagPathinaBinaryTree {
    // time / space O(n)
    fun longestZigZag(root: TreeNode?): Int {
        return zigzag(root?.left, 1, true).coerceAtLeast(zigzag(root?.right, 1, false))
    }

    private fun zigzag(root: TreeNode?, currentLength: Int, isPreviousLeft: Boolean): Int {
        return if (root == null) {
            currentLength-1
        } else {
            if (isPreviousLeft) {
                zigzag(root.right, currentLength + 1, false).coerceAtLeast(zigzag(root.left, 1, true))
            } else {
                zigzag(root.left, currentLength + 1, true).coerceAtLeast(zigzag(root.right, 1, false))
            }
        }
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}