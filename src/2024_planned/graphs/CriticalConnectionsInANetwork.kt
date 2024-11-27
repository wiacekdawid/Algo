package `2024_planned`.graphs

/**
 * There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections forming a network where connections[i] = [ai, bi]
 * represents a connection between servers ai and bi. Any server can reach other servers directly or indirectly through the network.
 * A critical connection is a connection that, if removed, will make some servers unable to reach some other server.
 * Return all critical connections in the network in any order.
 */
// time / space O(V+E)
class CriticalConnectionsInANetwork {
    fun criticalConnections(n: Int, connections: List<List<Int>>): List<List<Int>> {
        val adjacencyList = Array<MutableList<Int>>(n) { mutableListOf() }
        connections.forEach { edge ->
            adjacencyList[edge[0]].add(edge[1])
            adjacencyList[edge[1]].add(edge[0])
        }

        val discovery = IntArray(n) { -1 } // Discovery times of nodes
        val low = IntArray(n) { -1 } // Lowest point reachable from each node
        val bridges = mutableListOf<List<Int>>() // Store critical connections
        var time = 0 // Global timer for discovery times

        fun dfs(node: Int, parent: Int) {
            discovery[node] = time
            low[node] = time
            time++

            for (neighbor in adjacencyList[node]) {
                if (neighbor == parent) continue // Skip the edge back to the parent
                if (discovery[neighbor] == -1) {
                    // Neighbor hasn't been visited
                    dfs(neighbor, node)
                    // Update low-link value
                    low[node] = minOf(low[node], low[neighbor])

                    // Check if edge is a bridge
                    if (low[neighbor] > discovery[node]) {
                        bridges.add(listOf(node, neighbor))
                    }
                } else {
                    // Update low-link value for back edge
                    low[node] = minOf(low[node], discovery[neighbor])
                }
            }
        }

        // Perform DFS for all components
        for (i in 0 until n) {
            if (discovery[i] == -1) {
                dfs(i, -1)
            }
        }

        return bridges
    }
}