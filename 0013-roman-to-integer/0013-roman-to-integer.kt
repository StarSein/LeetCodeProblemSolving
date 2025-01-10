/**

 1. add value :
    1) I not followed by V or X
    2) V
    3) X not followed by L or C
    4) L
    5) C not followed by D or M
    6) D
    7) M
 2. subtract value :
    1) I followed by V or X
    2) X followed by L or C
    3) C followed by D or M

 */

class Solution {
    fun romanToInt(s: String): Int {

        val countMap = mapOf(
            'I' to 1,
            'V' to 5,
            'X' to 10,
            'L' to 50,
            'C' to 100,
            'D' to 500,
            'M' to 1000
        )

        val minusMap = mapOf(
            'I' to arrayOf('V', 'X'),
            'X' to arrayOf('L', 'C'),
            'C' to arrayOf('D', 'M')
        )

        val length = s.length
        val answer = s.mapIndexed { index, char ->
            val weight = if (index != length - 1 
                && minusMap[char]?.contains(s[index + 1]) == true) -1
            else 1
            weight * (countMap[char]?: 0)
        }.sum()

        return answer
    }
}