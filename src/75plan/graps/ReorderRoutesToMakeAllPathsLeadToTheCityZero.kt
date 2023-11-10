package `75plan`.graps

import java.util.*


/**
 * There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities (this network form a tree).
 * Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.
 * Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.
 * This year, there will be a big event in the capital (city 0), and many people want to travel to this city.
 * Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.
 * It's guaranteed that each city can reach city 0 after reorder.
 */

class ReorderRoutesToMakeAllPathsLeadToTheCityZero {
    var count = 0

    private fun dfs(node: Int, parent: Int, adj: Map<Int, List<List<Int>>>) {
        if (!adj.containsKey(node)) {
            return
        }
        adj[node]?.forEach {
            val child = it[0]
            val sign = it[1]
            if (child != parent) {
                count += sign
                dfs(child, node, adj)
            }
        }
    }

    // time / space O(n)
    fun minReorder(n: Int, connections: Array<IntArray>): Int {
        val adj: HashMap<Int, ArrayList<List<Int>>> = HashMap()

        for (connection in connections) {
            adj.computeIfAbsent(connection[0]) { ArrayList() }.add(listOf(connection[1], 1))
            adj.computeIfAbsent(connection[1]) { ArrayList() }.add(listOf(connection[0], 0))
        }

        dfs(0, -1, adj)

        return count
    }
}