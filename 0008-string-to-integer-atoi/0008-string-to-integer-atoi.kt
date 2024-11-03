import kotlin.math.max
import kotlin.math.min

/**
 Intuition:
    Handling the input number out of the integer range is the key point.
    To avoid Integer Overflow, use 64-bit integer as a variable.

 Approach
    1. Ignore leading whitespace
    2. Determine the sign
    3. Ignore leading zero (This will be seamlessly done)
    4. If non-digit character comes before the first digit character, return 0
    5. Every time reading digit characters, accumulate them into the output

 Time Complexity: O(n)

 Space Complexity: O(n)
 */

class Solution {

    fun myAtoi(s: String): Int {

        var output = 0L
        var isSignDetermined = false
        var positiveSign = true

        for (c in s) {
            if (c == ' ' && !isSignDetermined) continue
            if (!isSignDetermined) {
                if (c == '+') {
                    isSignDetermined = true
                    continue
                } else if (c == '-') {
                    isSignDetermined = true
                    positiveSign = false
                    continue
                }
            }
            if (!c.isDigit()) {
                break
            }
            isSignDetermined = true

            val digit = (c - '0').toLong()
            if (positiveSign) {
                output = min(Int.MAX_VALUE.toLong(), 10L * output + digit)
            } else {
                output = max(Int.MIN_VALUE.toLong(), 10L * output - digit)
            }
        }

        return output.toInt()
    }
}