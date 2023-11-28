package `75plan`.graps

/**
 * You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.
 * You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
 * Return the answers to all queries. If a single answer cannot be determined, return -1.0.
 * Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.
 * Note: The variables that do not occur in the list of equations are undefined, so the answer cannot be determined for them.
 */
class EvaluateDivision {
    fun calcEquation(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {
        val graph = HashMap<String, HashMap<String, Double>>()

        // creating the graph of dependencies
        equations.forEachIndexed { index, currentEquation ->
            val currentValue = values[index]

            if (!graph.containsKey(currentEquation[0])) {
                graph[currentEquation[0]] = HashMap()
            }

            if (!graph.containsKey(currentEquation[1])) {
                graph[currentEquation[1]] = HashMap()
            }

            graph[currentEquation[0]]?.put(currentEquation[1], currentValue)
            graph[currentEquation[1]]?.put(currentEquation[0], currentValue)
        }
    }

    private fun find() {

    }
}