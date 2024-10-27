import kotlin.math.max

/**

 Intuition:
 If a substring with range of [s:e] contains repeating characters,
 the range should be narrowed from at least one side.
 (ex. s++ or e--)

 Approach:
 1. Use two pointer to iterate the string given from left to right.
 2. While there is no repetition of character in the substring, move right pointer to right.
 3. Otherwise, move left pointer to right, so the substring can remove the repetition.
 4. Use a HashMap<Char, Int> for counting the numbers of each character in the substring,
    as the string consists of not only English letters, but also digits, symbols and spaces.

 Time-complexity: O(n)

 Space-complexity: O(n)

 */
class Solution {

    val counter: MutableMap<Char, Int> = HashMap()

    fun lengthOfLongestSubstring(s: String): Int {
        var answer = 0
        var start = 0
        var end = 0

        while (end < s.length) {
            val endChar = s[end]
            while (counter[endChar] != null && counter[endChar] == 1) {
                val startChar = s[start]
                start++
                counter[startChar]?.let { count ->
                    counter[startChar] = count - 1
                }
            }
            counter[endChar] = 1 + (counter[endChar] ?: 0)
            
            val length = end - start + 1
            answer = max(answer, length)
            end++
        }
        
        return answer
    }
}