package `2024_planned`.graphs

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 */

// time / space O(V+E)
class CourseSchedule {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val adjacencyList = Array(numCourses) { mutableListOf<Int>() }

        // Build adjacency list for the directed graph
        prerequisites.forEach {
            adjacencyList[it[1]].add(it[0])
        }

        val visited = BooleanArray(numCourses)
        val recStack = BooleanArray(numCourses)

        fun dfs(node: Int): Boolean {
            if (recStack[node]) return true // Cycle detected
            if (visited[node]) return false // Already processed this node

            visited[node] = true
            recStack[node] = true

            // Visit all neighbors
            for (neighbor in adjacencyList[node]) {
                if (dfs(neighbor)) return true
            }

            recStack[node] = false // Backtrack
            return false
        }

        for (i in 0 until numCourses) {
            if (!visited[i]) {
                if (dfs(i)) return false // Cycle detected
            }
        }

        return true // No cycle found
    }
}