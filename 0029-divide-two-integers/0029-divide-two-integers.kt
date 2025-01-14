import kotlin.math.abs
import kotlin.math.min

/**
 *
 * 1. If the signs of the dividend and divisor are same, the answer is positive value,
 *    otherwise, negative value.
 *    So, we may use only the absolute value of both of them, at first.
 * 2. If divisor is not 1, all the dividend can be indicated by base 'divisor'
 *    So, after converting dividend into base 'divisor',
 *    we can count the number of divisor used, in Time complexity of O(logP / logQ) (P = dividend, Q = divisor)
 *    converting dividend into base 'divisor' also require Time complexity of O(logP / logQ)
 * 3. Totally, we can calculate the answer
 *    using only addition and subtraction.
 *
 * 4. For simpler implementation, we can sacrifice the Time Complexity.
 *    If the divisor is above or equal to 2^10, we can naively subtract repeatedly.
 *    Even if the divisor is below 2^10, we can make new divisor which is above 2^10,
 *    and subtract repeatedly with new one at first, do the same thing with old one at second.
 */

class Solution {
    fun divide(dividend: Int, divisor: Int): Int {

        val sign = if (dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0) {
            1
        } else {
            -1
        }

        val p = abs(dividend.toLong())
        val q = abs(divisor.toLong())
        if (q == 1L) {
            return if (sign == 1) min(Int.MAX_VALUE.toLong(), p).toInt()
                   else (-p).toInt()
        }

        if (q >= 1024) {
            val (div, _) = divMod(p, q)
            return sign * div
        }

        var nq = q
        var cnt = 1
        while (nq < 1024) {
            nq += q
            cnt++
        }

        val (div1, mod1) = divMod(p, nq)
        val (div2, _) = divMod(mod1.toLong(), q)

        var answer = div2
        repeat(div1) {
            answer += cnt
        }

        return sign * answer
    }

    fun divMod(dividend: Long, divisor: Long): Pair<Int, Int> {
        var div = 0
        var temp = dividend
        while (temp >= divisor) {
            temp -= divisor
            div++
        }
        return div to temp.toInt()
    }
}