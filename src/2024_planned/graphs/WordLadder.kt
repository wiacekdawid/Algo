package `2024_planned`.graphs

/**
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * sk == endWord
 * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 */

// time O(NxLpow2) / space O(NxL)
class WordLadder {
    @OptIn(ExperimentalStdlibApi::class)
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        if (endWord !in wordList) return 0

        // Build the pattern-based adjacency list
        val patternMap = HashMap<String, MutableList<String>>()
        val allWords = wordList + beginWord

        allWords.forEach { word ->
            for (i in word.indices) {
                val pattern = word.substring(0, i) + "*" + word.substring(i + 1)
                patternMap.computeIfAbsent(pattern) { mutableListOf() }.add(word)
            }
        }

        // BFS setup
        val queue: ArrayDeque<Pair<String, Int>> = ArrayDeque()
        queue.add(Pair(beginWord, 1)) // Pair(word, level)
        val visited = mutableSetOf<String>()
        visited.add(beginWord)

        // BFS loop
        while (queue.isNotEmpty()) {
            val (currentWord, level) = queue.removeFirst()

            for (i in currentWord.indices) {
                val pattern = currentWord.substring(0, i) + "*" + currentWord.substring(i + 1)
                for (neighbor in patternMap[pattern] ?: mutableListOf()) {
                    if (neighbor == endWord) return level + 1
                    if (neighbor !in visited) {
                        visited.add(neighbor)
                        queue.add(Pair(neighbor, level + 1))
                    }
                }
            }
        }

        return 0 // No transformation sequence found
    }
}