package graphs

/**
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b,
 * and city b is connected directly with city c, then city a is connected indirectly with city c.
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 * Return the total number of provinces.
 */
class NumberOfProvinces {
    // time O(n pow2) / space O(n)
    fun findCircleNum(isConnected: Array<IntArray>): Int {
        var numberOfProvinces = 0
        val visited = BooleanArray(isConnected.size)

        for (i in isConnected.indices) {
            if (!visited[i]) {
                numberOfProvinces++
                dfs(visited, isConnected, i)
            }
        }

        return numberOfProvinces
    }

    private fun dfs(visited: BooleanArray, isConnected: Array<IntArray>, currentIndex: Int) {
        visited[currentIndex] = true
        for (i in isConnected.indices) {
            if (!visited[i] && isConnected[currentIndex][i] == 1) {
                dfs(visited, isConnected, i)
            }
        }
    }
}