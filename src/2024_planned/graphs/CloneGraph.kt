package `2024_planned`.graphs

/**
 * Given a reference of a node in a connected undirected graph.
 * Return a deep copy (clone) of the graph.
 * Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 */

// time O(V+E) / space O(V)
class CloneGraph {
    fun cloneGraph(node: Node?): Node? {
        if (node == null) return null

        val visited = mutableMapOf<Node?, Node?>()

        fun helper(node: Node?): Node? {
            if (node == null) return null
            if (visited.containsKey(node)) return visited[node]

            // Create a new node and store it in the visited map immediately
            val clonedNode = Node(node.`val`)
            visited[node] = clonedNode

            // Recursively clone neighbors
            clonedNode.neighbors = ArrayList(node.neighbors.map { helper(it) })

            return clonedNode
        }

        return helper(node)
    }

    class Node(var `val`: Int) {
        var neighbors: ArrayList<Node?> = ArrayList<Node?>()
    }
}