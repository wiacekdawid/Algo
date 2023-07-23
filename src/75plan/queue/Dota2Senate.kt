package `75plan`.queue

import java.util.*

/**
 * In the world of Dota2, there are two parties: the Radiant and the Dire.
 * The Dota2 senate consists of senators coming from two parties. Now the Senate wants to decide on a change in the Dota2 game. The voting for this change is a round-based procedure. In each round, each senator can exercise one of the two rights:
 * Ban one senator's right: A senator can make another senator lose all his rights in this and all the following rounds.
 * Announce the victory: If this senator found the senators who still have rights to vote are all from the same party, he can announce the victory and decide on the change in the game.
 * Given a string senate representing each senator's party belonging. The character 'R' and 'D' represent the Radiant party and the Dire party. Then if there are n senators, the size of the given string will be n.
 * The round-based procedure starts from the first senator to the last senator in the given order. This procedure will last until the end of voting. All the senators who have lost their rights will be skipped during the procedure.
 * Suppose every senator is smart enough and will play the best strategy for his own party. Predict which party will finally announce the victory and change the Dota2 game. The output should be "Radiant" or "Dire".
 */
class Dota2Senate {
    // Greedy algorithm - time O(powN) / space O(n)
    fun predictPartyVictory(senate: String): String {

        // Sentae Char Array
        var senateArray = senate.toCharArray()

        // Count of Each Type of Senator to check for Winner
        var rCount = senateArray.count { it == 'R' }
        var dCount = senateArray.size - rCount

        // Ban the candidate "toBan", immediate next to "startAt"
        // If have to loop around, then it means next turn will be of
        // senator at same index. Returns loop around boolean
        fun ban(toBan: Char, startAt: Int): Boolean {
            var loopAround = false
            var pointer = startAt

            while (true) {
                if (pointer == 0) {
                    loopAround = true
                }
                if (senateArray[pointer] == toBan) {
                    senateArray = senateArray.filterIndexed { index, _ -> index != pointer }.toCharArray()
                    return loopAround
                }
                pointer = (pointer + 1) % senateArray.size
            }

            loopAround
        }

        // Turn of Senator at this index
        var turn = 0

        // While No Winner
        while (rCount > 0 && dCount > 0) {

            // Ban the next opponent, starting at one index ahead
            // Taking MOD to loop around.
            // If index of banned senator is before current index,
            // then we need to decrement turn by 1, as we have removed
            // a senator from list
            if (senateArray[turn] == 'R') {
                val bannedSenatorBefore = ban('D', (turn + 1) % senateArray.size)
                dCount -= 1
                if (bannedSenatorBefore) {
                    turn -= 1
                }
            } else {
                val bannedSenatorBefore = ban('R', (turn + 1) % senateArray.size)
                rCount -= 1
                if (bannedSenatorBefore) {
                    turn -= 1
                }
            }

            // Increment turn by 1
            turn = (turn + 1) % senateArray.size
        }

        // Return Winner depending on count
        return if (dCount == 0) "Radiant" else "Dire"
    }
}