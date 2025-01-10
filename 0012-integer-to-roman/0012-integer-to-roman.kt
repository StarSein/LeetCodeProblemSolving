/**

 1. a = {I, X, C, M}
    b = {V, L, D}
 2. 1 - a
    2 - aa
    3 - aaa
    4 - ab
    5 - b
    6 - ba
    7 - baa
    8 - baaa
    9 - aa'
    10 - a'

 */

class Solution {
    fun intToRoman(num: Int): String {

        val a = listOf('I', 'X', 'C', 'M')
        val b = listOf('V', 'L', 'D')

        val stack = mutableListOf<String>()
        var temp = num
        var idx = 0
        while (temp > 0) {
            val decimal = temp % 10
            temp /= 10

            val roman = when (decimal) {
                1, 2, 3 -> Array(decimal) { a[idx] }.joinToString("")
                4 -> "${a[idx]}${b[idx]}"
                5 -> "${b[idx]}"
                6, 7, 8 -> "${b[idx]}${Array(decimal - 5) { a[idx] }.joinToString("")}"
                9 -> "${a[idx]}${a[idx + 1]}"
                else -> ""
            }

            stack.add(roman)
            idx++
        }

        return stack.reversed().joinToString("")
    }
}