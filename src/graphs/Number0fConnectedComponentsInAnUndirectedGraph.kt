package graphs

import com.sun.org.apache.xpath.internal.operations.Bool
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
    // time / space O(numOfEdges + numOfVertices)
    fun countComponents(n: Int, edges: Array<IntArray>): Int {
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
                dfs(adjList, visited, i)
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
        queue.offer(startNode)
        while (queue.isNotEmpty()) {
            val noddle = queue.poll()

        }
    }
}