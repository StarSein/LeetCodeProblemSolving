/**
 Intuition:
 Draw the zigzag pattern on the 2-dimensional array.
 There is regularity about how the characters are ordered on the output string.
 - y indices have a cycle from 0 until the number of rows.
 - A character which is assigned to a row before the others should be ordered before them.

 Approach:
 1. While iterating the input string, assign each character into the proper row
 2. Make the output string by appending rows from the lowest index.

 Time Complexity: O(N) (N is the length of the input string)
 Space Complexity: O(N)
 */
class Solution {

    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) return s

        val sbArr = Array<StringBuilder>(size = numRows, init = { StringBuilder() })

        var ascending = true
        var row = 0
        s.forEach {
            sbArr[row].append(it)

            if (ascending) row++
            else row--

            if (row == numRows - 1) ascending = false
            else if (row == 0) ascending = true
        }

        val answer = sbArr.joinToString(separator = "")
        return answer
    }
}