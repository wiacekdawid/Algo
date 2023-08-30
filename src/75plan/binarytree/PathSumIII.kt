package `75plan`.binarytree

import apple.laf.JRSUIUtils

/**
 * Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
 * The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
 */

fun main() {
    val root = TreeNode(10).apply {
        left = TreeNode(5).apply {
            left = TreeNode(3).apply {
                left = TreeNode(3)
                right = TreeNode(-2)
            }
            right = TreeNode(2).apply {
                right = TreeNode(1)
            }
        }
        right = TreeNode(-3).apply {
            right = TreeNode(11)
        }
    }

    val test = PathSumIII().pathSum(root, 8)
}

class PathSumIII {
    // prefix sum solution time/space O(n)
    fun pathSum(root: TreeNode?, targetSum: Int): Int {
        val prefixSum = mutableListOf<Int>()
        return checkSum(root, mutableListOf(), targetSum)
    }

    private fun checkPrefixSum(root: TreeNode?, prefixSum: List<Int>) {

    }

    private fun checkSum(root: TreeNode?, list: List<Int>, targetSum: Int): Int {
        return if (root == null) {
            0
        } else {
            val newList: List<Int> = listOf(root.`val`).plus(list)
            val isTargetSumWork: Boolean = checkIfTargetSumWork(newList, targetSum)
            if (isTargetSumWork) {
                1
            } else {
                0
            } + checkSum(root.left, newList, targetSum) + checkSum(root.right, newList, targetSum)
        }
    }

    private fun checkIfTargetSumWork(list: List<Int>, targetSum: Int): Boolean {
        var sum = 0
        println("Sum  = ${list.joinToString()}")
        list.forEach {
            sum += it
            if (sum == targetSum) return true
        }
        println("Sum  = zwracam false")
        return false
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}