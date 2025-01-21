/**
 *
 * Suppose L is the length of num2
 * 1. Multiply num1 with each digit of num2 so that the number of generated nums is L.
 * 2. Add all generated nums each other, that is the answer
 *
 */

class Solution {
    fun multiply(num1: String, num2: String): String {
        if (num1 == "0" || num2 == "0") {
            return "0"
        }
        
        val reversedNum1 = num1.reversed()
        val reversedNum2 = num2.reversed()

        val generatedNums = reversedNum2.mapIndexed { index, digit ->
            multiplyDigit(reversedNum1, digit - '0', index)
        }

        val answer = generatedNums.reduce { acc, item ->
            acc.add(item)
        }

        return answer
    }

    fun multiplyDigit(reversedNum: String, digit: Int, zeroCount: Int): String {
        val sb = StringBuilder()
        var carriage = 0
        for (c in reversedNum) {
            val d = c - '0'
            val m = d * digit
            val tenDigit = m / 10
            val oneDigit = m % 10

            if (oneDigit + carriage >= 10) {
                sb.append(oneDigit + carriage - 10)
                carriage = tenDigit + 1
            } else {
                sb.append(oneDigit + carriage)
                carriage = tenDigit
            }
        }
        if (carriage != 0) {
            sb.append(carriage)
        }

        sb.reverse()

        repeat(zeroCount) {
            sb.append('0')
        }

        return sb.toString()
    }

    fun String.add(s: String): String {

        val (s1, s2) = if (this.length >= s.length) this.reversed() to s.reversed()
        else s.reversed() to this.reversed()

        val sb = StringBuilder()

        var carriage = 0
        for (i in s1.indices) {
            val d1 = s1[i] - '0'
            val d2 = if (i < s2.length) s2[i] - '0'
            else 0

            val sum = d1 + d2 + carriage
            if (sum >= 10) {
                sb.append(sum - 10)
                carriage = 1
            } else {
                sb.append(sum)
                carriage = 0
            }
        }
        if (carriage != 0) {
            sb.append(1)
        }
        
        sb.reverse()

        return sb.toString()
    }
}