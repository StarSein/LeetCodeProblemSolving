/**
 *
 * Time Complexity: O(N!)
 * Space Complexity: O(N)
 *
 */

class Solution {
    
    lateinit var cols: BooleanArray
    lateinit var ascends: BooleanArray
    lateinit var descends: BooleanArray
    lateinit var tgt: IntArray
    val answer = mutableListOf<List<String>>()
    
    var size: Int = -1

    fun solveNQueens(n: Int): List<List<String>> {
        cols = BooleanArray(n)
        ascends = BooleanArray(2 * n - 1)
        descends = BooleanArray(2 * n - 1)
        tgt = IntArray(n)
        
        size = n
        
        recur(0)
        
        return answer
    }
    
    fun recur(row: Int) {
        if (row == size) {
            val s = tgt.map {
                val sb = StringBuilder()
                repeat(it) {
                    sb.append(".")
                }
                sb.append("Q")
                repeat(size - 1 - it) {
                    sb.append(".")
                }
                
                sb.toString()
            }
            answer.add(s)
            return
        }
        
        repeat(size) { col ->
            val asc = row + col
            val desc = -row + col + size - 1
            if (!cols[col] && !ascends[asc] && !descends[desc]) {
                cols[col] = true
                ascends[asc] = true
                descends[desc] = true
                tgt[row] = col
                
                recur(row + 1)
                
                cols[col] = false
                ascends[asc] = false
                descends[desc] = false
            }
        }
    }
}