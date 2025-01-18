/**
 *
 * Do brute-force, but minimize the number of case using this approach.
 * 1. Find the blank where the number of the possible digit is the smallest.
 * 2. Fill the blank with a possible digit.
 * 3. Repeat task 1,2 until the entire board is filled.
 *
 */

class Solution {

    val rows = IntArray(9) { 0 }
    val columns = IntArray(9) { 0 }
    val subBoxes = IntArray(9) { 0 }
    val blanks = mutableSetOf<Pair<Int, Int>>()
    var answerFound = false

    fun solveSudoku(board: Array<CharArray>): Unit {
        // process board input
        for (r in 0..8) {
            for (c in 0..8) {
                val char = board[r][c]
                if (char == '.') {
                    blanks.add(Pair(r, c))
                } else {
                    val digit = char - '0'
                    val sb = getSubBoxIndex(r, c)
                    rows[r] = rows[r] or (1 shl digit)
                    columns[c] = columns[c] or (1 shl digit)
                    subBoxes[sb] = subBoxes[sb] or (1 shl digit)
                }
            }
        }

        // using backtracking, fill the blank
        recur(board)
    }

    fun recur(board: Array<CharArray>) {
        if (blanks.isEmpty()) {
            answerFound = true
            return
        }

        if (answerFound) {
            return
        }

        val (location, possibleDigits) = blanks.map { it to getPossibleDigits(it.first, it.second) }
            .reduce { s, t ->
                if (s.second.size > t.second.size) t
                else s
            }
        val (r, c) = location
        val sb = getSubBoxIndex(r, c)
        blanks.remove(r to c)
        for (digit in possibleDigits) {
            if (answerFound) {
                return
            }
            board[r][c] = '0' + digit

            rows[r] = rows[r] or (1 shl digit)
            columns[c] = columns[c] or (1 shl digit)
            subBoxes[sb] = subBoxes[sb] or (1 shl digit)

            recur(board)

            rows[r] = rows[r] xor (1 shl digit)
            columns[c] = columns[c] xor (1 shl digit)
            subBoxes[sb] = subBoxes[sb] xor (1 shl digit)
        }
        blanks.add(r to c)
    }

    fun getPossibleDigits(r: Int, c: Int): IntArray {
        val sb = getSubBoxIndex(r, c)
        return (1..9).filter { digit ->
            !isRepeated(rows[r], digit) &&
            !isRepeated(columns[c], digit) &&
            !isRepeated(subBoxes[sb], digit)
        }.toIntArray()
    }

    fun isRepeated(bitmask: Int, digit: Int): Boolean {
        return (bitmask and (1 shl digit)) != 0
    }

    fun getSubBoxIndex(r: Int, c: Int): Int {
        return 3 * (r / 3) + (c / 3)
    }
}