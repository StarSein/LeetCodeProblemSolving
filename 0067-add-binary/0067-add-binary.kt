class Solution {
    fun addBinary(a: String, b: String): String {
        val (short, long) = if (a.length < b.length) a to b
                            else b to a
        val rs = (short.reversed() + CharArray(long.length - short.length) { '0' }.joinToString(""))
            .map { it - '0' }
        val rl = long.reversed()
            .map { it - '0' }
        
        val answer = StringBuilder()
        var carriage = 0
        repeat(rl.size) {
            val digit = rs[it] + rl[it] + carriage
            if (digit >= 2) {
                answer.append(digit - 2)
                carriage = 1
            } else {
                answer.append(digit)
                carriage = 0
            }
        }
        if (carriage == 1) {
            answer.append(1)
        }

        return answer.reversed().toString()
    }
}