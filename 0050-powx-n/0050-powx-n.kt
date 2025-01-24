import kotlin.math.abs

class Solution {
    fun myPow(x: Double, n: Int): Double {

        val cache = DoubleArray(32) { 0.0 }
        // cache[i]: x^(2^i)
        cache[0] = x

        repeat(cache.size - 1) {
            cache[it + 1] = cache[it] * cache[it]
        }

        var nl = abs(n.toLong())
        
        val pow = cache.foldIndexed(1.0) { index, acc, c ->
            if (isBitOn(nl, index)) {
                acc * c
            } else {
                acc
            }
        }
        
        val answer = if (n > 0) pow
        else 1.0 / pow
        
        return answer
    }

    // return whether the binary of number contains '1' which indicate 2^i
    fun isBitOn(num: Long, i: Int): Boolean {
        return (num and (1L shl i)) != 0L
    }
}