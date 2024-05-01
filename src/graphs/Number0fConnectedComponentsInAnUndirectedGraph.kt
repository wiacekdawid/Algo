package graphs

import java.util.*

/**
 * You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi]
 * indicates that there is an edge between ai and bi in the graph.
 * Return the number of connected components in the graph.
 */

fun main() {
    val test = Number0fConnectedComponentsInAnUndirectedGraph()
        .countComponents(4, arrayOf(intArrayOf(0,1), intArrayOf(2,3), intArrayOf(1,2)))
}

class Number0fConnectedComponentsInAnUndirectedGraph {
    // disjoint set union
    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        val representative = IntArray(size = n)
        val size = IntArray(size = n)

        for (i in 0 until n) {
            representative[i] = i
            size[i] = 1
        }

        var numOfComponents = n
        for (i in edges.indices) {
            numOfComponents -= combine(representative, size, edges[i][0], edges[i][1])
        }
        return numOfComponents
    }

    private fun combine(representative: IntArray, size: IntArray, vertex1: Int, vertex2: Int): Int {
        val _vertex1 = find(representative, vertex1)
        val _vertex2 = find(representative, vertex2)

        if (_vertex1 == _vertex2) {
            return 1
        }
        return 0
    }

    private fun find(representative: IntArray, vertex: Int): Int {
        if (vertex == representative[vertex]) {
            return vertex
        }
        return 0
    }

    // time / space O(numOfEdges + numOfVertices)
    fun countComponents2(n: Int, edges: Array<IntArray>): Int {
        val visited = BooleanArray(size = n)
        var numOfComponents = 0

        val adjList = List(size = n) { mutableListOf<Int>() }

        edges.forEach { currentEdge ->
            val first = currentEdge[0]
            val second = currentEdge[1]
            adjList[first].add(second)
            adjList[second].add(first)
        }

        for (i in 0 until n) {
            if (!visited[i]) {
                numOfComponents++
//                dfs(adjList, visited, i)
                bfs(adjList, visited, i)
            }
        }
        return numOfComponents
    }

    private fun dfs(adjList: List<List<Int>>, visited: BooleanArray, startNode: Int) {
        visited[startNode] = true

        adjList[startNode].forEach {
            if (!visited[it]) {
                dfs(adjList, visited, it)
            }
        }
    }

    private fun bfs(adjList: List<List<Int>>, visited: BooleanArray, startNode: Int) {
        val queue = LinkedList<Int>()
        queue.addAll(adjList[startNode])
        while (queue.isNotEmpty()) {
            val current = queue.poll()
            if (!visited[current]) {
                visited[current] = true
                queue.addAll(adjList[current])
            }
        }
    }
}