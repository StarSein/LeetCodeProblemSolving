class Solution {
    fun plusOne(digits: IntArray): IntArray {
        val answer = mutableListOf<Int>()
        var carriage = 1
        for (i in digits.lastIndex downTo 0) {
            val newDigit = digits[i] + carriage
            if (newDigit >= 10) {
                answer.add(newDigit - 10)
                carriage = 1
            } else {
                answer.add(newDigit)
                carriage = 0
            }
        }
        if (carriage == 1) {
            answer.add(1)
        }
        return answer.reversed().toIntArray()
    }
}