/**
 *
 * Two-pointer
 *
 * Time Complexity: O(M + N)
 * Space Complexity: O(1)
 *
 */


class Solution {

    fun minWindow(s: String, t: String): String {

        // Count the numbers of each character which is contained in `t`
        val nums = IntArray(52) { 0 }
        t.forEach { c -> charToInt(c).let { nums[it]++ } }
        var lackCount = nums.count { it != 0 }

        // From the left side of `s`, adjust the range of the window substring
        val INF = -1 to s.length
        var opt = INF
        val counts = IntArray(52) { 0 }
        var l = 0
        var r = 0
        while (r < s.length || lackCount == 0) {
            // Expand the substring while it doesn't meet the condition
            if (lackCount > 0) {
                charToInt(s[r++]).let {
                    if (++counts[it] == nums[it]) {
                        lackCount--
                    }
                }
            } else {
                // Update the minimum length and answer
                opt = minOf(opt, l to r) { a, b ->
                    (a.second - a.first) - (b.second - b.first)
                }

                // Shrink the substring while it meet the condition
                charToInt(s[l++]).let {
                    if (counts[it]-- == nums[it]) {
                        lackCount++
                    }
                }
            }
        }

        // Return answer
        val answer = if (opt == INF) ""
        else s.substring(opt.first, opt.second)
        return answer
    }

    fun charToInt(ch: Char): Int {
        return if (ch.isUpperCase()) ch - 'A' + 26
        else ch - 'a'
    }
}