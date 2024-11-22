package `2024_planned`.graphs

import java.util.*

/**
 * You have a graph of n nodes labeled from 0 to n - 1.
 * You are given an integer n and a list of edges where edges[i] = [ai, bi] indicates that there is an undirected edge between nodes ai and bi in the graph.
 * Return true if the edges of the given graph make up a valid tree, and false otherwise.
 */
// time O(V+E) / space O(V+E)
class GraphValidTree {
    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
        if (edges.size != n-1) return false

        val adjList = mutableMapOf<Int, MutableList<Int>>()
        for (i in 0 until n) {
            adjList[i] = mutableListOf()
        }

        edges.forEach {
            adjList[it.first()]?.add(it[1])
            adjList[it[1]]?.add(it.first())
        }

        // Use BFS to check for connectivity and cycles
        val visited = mutableSetOf<Int>()
        val queue: Queue<Int> = LinkedList()
        queue.add(0) // Start BFS from node 0

        while (queue.isNotEmpty()) {
            val node = queue.poll()
            if (visited.contains(node)) continue
            visited.add(node)

            for (neighbor in adjList[node] ?: mutableListOf()) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor)
                    // Remove the back edge to prevent revisiting the parent
                    adjList[neighbor]?.remove(node)
                }
            }
        }

        // Check if all nodes are visited
        return visited.size == n
    }
}