package `75plan`.graps

/**
 * There are n cities. Some of them are connected, while some are not.
 * If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 * Return the total number of provinces.
 */
class NumberOfProvinces {
    // time O(n pow2)  / space O(n)
    fun findCircleNum(isConnected: Array<IntArray>): Int {
        val visited = BooleanArray(isConnected.size)
        var numOfComponents = 0

        for (i in isConnected.indices) {
            if (!visited[i]) {
                numOfComponents++
                dfs(i, isConnected, visited)
            }
        }
        return numOfComponents
    }

    private fun dfs(currentNode: Int, isConnected: Array<IntArray>, visited: BooleanArray) {
        visited[currentNode] = true
        for (i in isConnected.indices) {
            if (isConnected[currentNode][i] == 1 && !visited[i]) {
                dfs(i, isConnected, visited)
            }
        }
    }
}