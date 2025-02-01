/**
 * 
 * Time Complexity: O(sqrtN)
 * Space Complexity: O(1)
 * 
 */


class Solution {
    fun mySqrt(x: Int): Int {
        var i = 1L
        while (i * i <= x) {
            i++
        }
        return i.toInt() - 1
    }
}