/**
 * 
 * 1. O(mn) space : Use 2D-array of boolean type for storing whether the corresponding item is zero or not.
 * 2. O(m+n) space : Use two array of boolean type. One is for all rows, another for all columns.
 * 3. O(1) space : Use 14 bitmasks of integer type. 7 bitmasks are for all rows, the others for all columns.
 * 
 */


class Solution {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        val m = matrix.size
        val n = matrix[0].size
        
        val masks = IntArray(14) { 0 }
        for (row in 0..<m) {
            for (col in 0..<n) {
                if (matrix[row][col] == 0) {
                    val (ri, rb) = rowToBitmask(row)
                    val (ci, cb) = columnToBitmask(col)
                    masks[ri] = masks[ri] or (1 shl rb)
                    masks[ci] = masks[ci] or (1 shl cb)
                }
            }
        }
        
        for (row in 0..<m) {
            val (ri, rb) = rowToBitmask(row)
            if ((masks[ri] and (1 shl rb)) != 0) {
                for (col in 0..<n) {
                    matrix[row][col] = 0
                }
            }
        }
        for (col in 0..<n) {
            val (ci, cb) = columnToBitmask(col)
            if ((masks[ci] and (1 shl cb)) != 0) {
                for (row in 0..<m) {
                    matrix[row][col] = 0
                }
            }
        }
    }

    /**
     * @return the index of bitmask and the particular bit 
     *         corresponding to the row 
     */
    fun rowToBitmask(row: Int): Pair<Int, Int> {
        return (row / 30) to (row % 30)
    }

    /**
     * @return the index of bitmask and the particular bit 
     *         corresponding to the column
     */
    fun columnToBitmask(column: Int): Pair<Int, Int> {
        return (7 + column / 30) to (column % 30)
    }
}