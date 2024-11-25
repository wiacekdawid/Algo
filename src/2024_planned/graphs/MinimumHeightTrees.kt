package `2024_planned`.graphs

import java.util.*

/**
 * A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.
 * Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] indicates that there is an undirected edge between
 * the two nodes ai and bi in the tree, you can choose any node of the tree as the root.
 * When you select a node x as the root, the result tree has height h. Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).
 * Return a list of all MHTs' root labels. You can return the answer in any order.
 * The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 */

// time / space O(V+E)
class MinimumHeightTrees {
    fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
        if (n == 1) return listOf(0) // Special case: only one node
        if (edges.isEmpty()) return emptyList() // Special case: no edges

        // Step 1: Build adjacency list
        val adjacencyList = Array<MutableList<Int>>(n) { mutableListOf() }
        edges.forEach {
            adjacencyList[it[0]].add(it[1])
            adjacencyList[it[1]].add(it[0])
        }

        // Step 2: Initialize leaf nodes
        val queue = LinkedList<Int>()
        for (i in adjacencyList.indices) {
            if (adjacencyList[i].size == 1) {
                queue.add(i)
            }
        }

        // Step 3: Trim the tree until 1 or 2 nodes remain
        var remainingNodes = n
        while (remainingNodes > 2) {
            val leafCount = queue.size
            remainingNodes -= leafCount

            repeat(leafCount) {
                val leaf = queue.poll()
                for (neighbor in adjacencyList[leaf]) {
                    adjacencyList[neighbor].remove(leaf)
                    if (adjacencyList[neighbor].size == 1) {
                        queue.add(neighbor)
                    }
                }
            }
        }

        // Step 4: The remaining nodes in the queue are the roots of MHTs
        return queue.toList()
    }
}