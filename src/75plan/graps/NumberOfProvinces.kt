package `75plan`.graps

/**
 * There are n cities. Some of them are connected, while some are not.
 * If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 * Return the total number of provinces.
 */
class NumberOfProvinces {
    fun findCircleNum(isConnected: Array<IntArray>): Int {
        val listOfSets = mutableListOf<MutableSet<Int>>()

        isConnected.forEachIndexed { indexCol, ints ->
            ints.forEachIndexed { indexRow, i ->
                if (i == 1) {
                    val firstItem = isExist(listOfSets, indexCol)
                    val secondItem = isExist(listOfSets, indexRow)

                    if (firstItem && !secondItem) {
                        listOfSets.forEach {
                            if (it.contains(indexCol)) {
                                it.add(indexRow)
                            }
                        }
                    } else if (!firstItem && secondItem) {
                        listOfSets.forEach {
                            if (it.contains(indexRow)) {
                                it.add(indexCol)
                            }
                        }
                    } else if (!firstItem && !secondItem) {
                        listOfSets.add(mutableSetOf(indexCol, indexRow))
                    }
                }
            }
        }

        return listOfSets.size
    }

    private fun isExist(listOfSets: MutableList<MutableSet<Int>>, checkedItem: Int) : Boolean {
        listOfSets.forEach {
            if (it.contains(checkedItem)) return true
        }
        return false
    }
}