package treesandgraphs.topologicalsort

import java.util.*


/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 * time / space O(E+V) where V num of courses / E num of dependencies
 */

class CourseSchedule {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        if (prerequisites.isEmpty()) return true

        val graph = mutableMapOf<Int, GraphNode>()

        prerequisites.forEach {
            // relation[1] -> relation[0]
            val prevCourse: GraphNode = getCreateGNode(graph, it[1])
            val nextCourse: GraphNode = getCreateGNode(graph, it[0])

            prevCourse.outNodes.add(it[0])
            nextCourse.inDegrees += 1
        }

        // We start from courses that have no prerequisites.
        val totalDeps: Int = prerequisites.size
        val nodepCourses = LinkedList<Int>()
        for ((key, node) in graph) {
            if (node.inDegrees == 0) nodepCourses.add(key)
        }

        var removedEdges = 0
        while (nodepCourses.size > 0) {
            val course = nodepCourses.pop()
            for (nextCourse in graph[course]!!.outNodes) {
                val childNode: GraphNode = graph[nextCourse] ?: GraphNode()
                childNode.inDegrees = childNode.inDegrees - 1
                removedEdges += 1
                if (childNode.inDegrees == 0) nodepCourses.add(nextCourse)
            }
        }

        return removedEdges == totalDeps
    }

    /**
     * Retrieve the existing <key></key>, value> from graph, otherwise create a new one.
     */
    private fun getCreateGNode(graph: MutableMap<Int, GraphNode>, course: Int): GraphNode {
        if (!graph.containsKey(course)) {
            graph[course] = GraphNode()
        }
        return graph[course] ?: GraphNode()
    }

    data class GraphNode(var inDegrees: Int = 0, val outNodes: LinkedList<Int> = LinkedList())
}