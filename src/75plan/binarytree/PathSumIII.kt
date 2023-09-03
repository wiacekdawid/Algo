package `75plan`.binarytree


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
    var count: Int = 0
    var k = 0
    var h: HashMap<Long, Int> = HashMap()
    fun pathSum(root: TreeNode?, targetSum: Int): Int {
        k = targetSum
        checkPrefixSum(root, 0L)
        return count
    }

    private fun checkPrefixSum(root: TreeNode?, currentSum: Long) {
        if (root == null) return

        var newSum = currentSum + root.`val`

        if (newSum == k.toLong()) count++

        count += h.getOrDefault(newSum.toLong() - k, 0)
        h[newSum.toLong()] = h.getOrDefault(newSum.toLong(), 0) + 1

        checkPrefixSum(root.left, newSum)
        checkPrefixSum(root.right, newSum)

        h[newSum] = h.getOrDefault(newSum, 1) - 1
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}