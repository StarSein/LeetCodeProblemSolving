/**
 *
 * Use bitmask to check repetition
 *
 */

class Solution {

    val rows = IntArray(9) { 0 }
    val columns = IntArray(9) { 0 }
    val subBoxes = IntArray(9) { 0 }

    fun isValidSudoku(board: Array<CharArray>): Boolean {
        for (r in 0..8) {
            val row = board[r]
            for (c in 0..8) {
                val char = row[c]
                if (char == '.') {
                    continue
                }
                
                val digit = char - '0'
                val sb = getSubBoxIndex(r, c)
                
                if (repeated(rows[r], digit)
                    || repeated(columns[c], digit)
                    || repeated(subBoxes[sb], digit)) {
                    return false
                }
                rows[r] = rows[r] or (1 shl digit)
                columns[c] = columns[c] or (1 shl digit)
                subBoxes[sb] = subBoxes[sb] or (1 shl digit)
            }
        }
        return true
    }

    fun repeated(bitmask: Int, digit: Int): Boolean {
        return (bitmask and (1 shl digit)) != 0
    }
    
    fun getSubBoxIndex(r: Int, c: Int): Int {
        return 3 * (r / 3) + (c / 3)
    }
}