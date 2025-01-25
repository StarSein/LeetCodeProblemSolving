class Solution {

    lateinit var cols: BooleanArray
    lateinit var ascends: BooleanArray
    lateinit var descends: BooleanArray

    var size = -1

    fun totalNQueens(n: Int): Int {
        cols = BooleanArray(n)
        ascends = BooleanArray(2 * n - 1)
        descends = BooleanArray(2 * n - 1)

        size = n

        return recur(0)
    }

    fun recur(row: Int): Int {
        if (row == size) {
            return 1
        }

        return (0..<size).sumOf { col ->
            val asc = row + col
            val desc = -row + col + size - 1
            if (cols[col] || ascends[asc] || descends[desc]) {
                0
            } else {
                cols[col] = true
                ascends[asc] = true
                descends[desc] = true

                val res = recur(row + 1)

                cols[col] = false
                ascends[asc] = false
                descends[desc] = false

                res
            }
        }
    }
}