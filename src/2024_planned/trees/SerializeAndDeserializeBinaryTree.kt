package `2024_planned`.trees

import java.util.*

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer,
 * or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format,
 * so please be creative and come up with different approaches yourself.
 */

// time / space O(n)
class SerializeAndDeserializeBinaryTree {
    // Encodes a URL to a shortened URL.
    fun serialize(root: TreeNode?): String {
        if (root == null) return ""

        val queue = ArrayDeque<TreeNode?>()
        queue.add(root)
        val serializeList = mutableListOf<String>()

        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()
            if (current == null) {
                serializeList.add("null")
            } else {
                serializeList.add(current.`val`.toString())
                queue.add(current.left)
                queue.add(current.right)
            }
        }

        return serializeList.joinToString(separator = ",")
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        if (data.isEmpty()) return null

        val serializedList = data.split(',')
        val root = TreeNode(serializedList[0].toInt())
        val queue = ArrayDeque<TreeNode?>()
        queue.add(root)
        var index = 1

        while (queue.isNotEmpty() && index < serializedList.size) {
            val current = queue.removeFirst()

            if (serializedList[index] != "null") {
                current?.left = TreeNode(serializedList[index].toInt())
                queue.add(current?.left)
            }
            index++

            if (index < serializedList.size && serializedList[index] != "null") {
                current?.right = TreeNode(serializedList[index].toInt())
                queue.add(current?.right)
            }
            index++
        }

        return root
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}