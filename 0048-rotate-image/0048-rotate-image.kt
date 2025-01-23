/**
 *
 * For every r and c, the clockwise rotation make an item move
 * from (r, c) to (c, n-1-r).
 *
 * And four items can be a group, so we can make a chain of movement.
 * Then only a few Int variables are needed
 * to prevent losing previous value on the location.
 *
 */

class Solution {

    fun rotate(matrix: Array<IntArray>): Unit {
        val n = matrix.size
        
        val rowRepCount = (n + 1) / 2
        val colRepCount = n / 2
        repeat(rowRepCount) { startRow ->
            repeat(colRepCount) { startCol ->
                var curRow = startRow
                var curCol = startCol
                var curVal = matrix[curRow][curCol]
                repeat(4) {
                    val nextRow = curCol
                    val nextCol = n - 1 - curRow
                    val nextVal = matrix[nextRow][nextCol]

                    matrix[nextRow][nextCol] = curVal

                    curRow = nextRow
                    curCol = nextCol
                    curVal = nextVal
                }
            }
        }
    }
}