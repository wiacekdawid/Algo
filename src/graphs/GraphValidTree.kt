package graphs

import java.util.*


/**
 * You have a graph of n nodes labeled from 0 to n - 1. You are given an integer n and a list of edges where edges[i] = [ai, bi]
 * indicates that there is an undirected edge between nodes ai and bi in the graph.
 * Return true if the edges of the given graph make up a valid tree, and false otherwise.
 */
class GraphValidTree {
    /**
     * Depth first search - is valid if:
     * 1) Graph is fully connected (if we start from top and we going through all the nodes - condition 'parent.size == n')
     * 2) Graph contains no cycles (if we are never going back when we are going through the nodes - condition 'if (parent[node] == neighbour)')
     */
    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
        val adjacencyList: MutableList<MutableList<Int>> = ArrayList()
        for (i in 0 until n) {
            adjacencyList.add(ArrayList())
        }
        for (edge in edges) {
            adjacencyList[edge[0]].add(edge[1])
            adjacencyList[edge[1]].add(edge[0])
        }

        val parent: MutableMap<Int, Int?> = HashMap()
        parent[0] = -1
        val stack = Stack<Int>()
        stack.push(0) // graph of n nodes labeled from 0 to n - 1 so we are taking 0

        while (!stack.isEmpty()) {
            val node = stack.pop()
            for (neighbour in adjacencyList[node]) {
                if (parent[node] == neighbour) {
                    continue
                }
                if (parent.containsKey(neighbour)) {
                    return false
                }
                stack.push(neighbour)
                parent[neighbour] = node
            }
        }

        return parent.size == n
    }

    /**
     * Breadth first search - is valid if:
     * 1) Graph is fully connected (if we start from top and we going through all the nodes - condition 'parent.size == n')
     * 2) Graph contains no cycles (if we are never going back when we are going through the nodes - condition 'if (parent[node] == neighbour)')
     */
    fun validTree2(n: Int, edges: Array<IntArray>): Boolean {
        edges.forEach {  }
    }
}