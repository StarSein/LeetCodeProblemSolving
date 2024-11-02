/**
 Intuition:
 Be cautious on the case that triggers Integer Overflow.

 Approach:
 1. If the last digit is 0, there is no possibility of Integer Overflow when reversing.
    - So naive reversing is valid.
 2. Else if the absolute value of the input is lower than 10^9, there is no possibility of Integer Overflow
    - So naive reversing is valid.
 3. Else, to avoid Integer Overflow, split the input into two part:
    part A: the first digit
    part B: the other digits
    1) if reverse of B exceed (MAX_INTEGER/10) => return 0
    2) else if reverse of B equals (MAX_INTEGER/10) and A exceed (MAX_INTEGER%10) => return 0
    3) else => naive reversing is valid
 Time Complexity: O(1)

 Space Complexity: O(1)
 */

class Solution {

    fun reverse(x: Int): Int {
        val POS = 1_000_000_000
        val NEG = -1_000_000_000

        if (x % 10 == 0) return naiveReverse(x)
        if (x in NEG..POS) return naiveReverse(x)

        if (x > 0) {
            val a = x / POS
            val b = absMod(x, POS)
            val reverseB = naiveReverse(b)
            val reverseMax = Int.MAX_VALUE / 10
            if (reverseB > reverseMax) return 0
            if (reverseB == reverseMax && a > absMod(Int.MAX_VALUE, 10)) return 0
        } else {
            val a = x / POS
            val b = absMod(x, POS)
            val reverseB = naiveReverse(b)
            val reverseMax = Int.MIN_VALUE / 10 * -1
            if (reverseB > reverseMax) return 0
            if (reverseB == reverseMax && a > absMod(Int.MIN_VALUE, 10)) return 0
        }
        
        return naiveReverse(x)
    }

    fun absMod(x: Int, mod: Int): Int {
        return if (x > 0) x % mod
            else (mod - x % mod) % mod
    }

    fun naiveReverse(x: Int): Int {
        var (weight, absX) = if (x > 0) 1 to x
                            else -1 to -x
        var absRet = 0
        while (absX > 0) {
            absRet *= 10
            absRet += absX % 10

            absX /= 10
        }

        return weight * absRet
    }
}