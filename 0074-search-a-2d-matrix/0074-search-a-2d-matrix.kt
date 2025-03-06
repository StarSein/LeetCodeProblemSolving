/**
 * 
 * 1. Search the appropriate row for containing the target - O(logM)
 * 2. Search the target on the row - O(logN)
 * 
 * So, total time complexity is O(logMN)
 * 
 */


class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val n = matrix[0].size
        
        val rowIndex = binarySearch(
            start = 0,
            end = matrix.lastIndex,
            isTargetContained = { target in matrix[it][0]..matrix[it][n - 1] },
            isTargetOnRight = { target > matrix[it][n - 1] }
        )
        if (rowIndex == -1) {
            return false
        }
        
        val row = matrix[rowIndex]
        val colIndex = binarySearch(
            start = 0,
            end = n - 1,
            isTargetContained = { target == row[it] },
            isTargetOnRight = { target > row[it] }
        )
        return colIndex != -1
    }

    /**
     * @return index where the target can be contained, 
     *         -1 if there is no such index
     */
    fun binarySearch(
        start: Int,
        end: Int,
        isTargetContained: (Int) -> Boolean,
        isTargetOnRight: (Int) -> Boolean
    ): Int {
        var s = start
        var e = end
        while (s <= e) {
            val m = (s + e) / 2
            
            if (isTargetContained(m)) {
                return m
            } else if (isTargetOnRight(m)) {
                s = m + 1
            } else {
                e = m - 1
            }
        }
        return -1
    }
}