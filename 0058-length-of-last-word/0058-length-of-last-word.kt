/**
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 *
 */


class Solution {
    fun lengthOfLastWord(s: String): Int {
        var answer = 0
        var existLetter = false

        for (i in s.lastIndex downTo 0) {
            if (s[i] == ' ') {
                if (existLetter) {
                    return answer
                }
            } else {
                existLetter = true
                answer++
            }
        }

        return answer
    }
}