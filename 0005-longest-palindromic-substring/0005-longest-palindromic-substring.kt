/**

 Intuition:
     O(N^3) with naive approach
         Task 1. iterate all the case of substring - O(N^2)
         Task 2. determine whether a substring is palindrome or not - O(N)

 Approach:
     With memoization, Task 2 can be optimized into time complexity O(1),
     if and only if the iteration starts from the shortest substrings and caching them.
     This approach has time complexity O(N^2) and also space complexity O(N^2) for memoization.

     In fact, there is no need to do memoization if the approach's two tasks change.
         Task 1. iterate all middle point of substring - O(N)
                1) all single character
                2) all character pair neighboring each other
         Task 2. spread the length of substring if current substring is a palindrome - O(N)
     With this two tasks, time complexity gets O(N^2) and space complexity gets O(N)

 */

class Solution {
    fun longestPalindrome(s: String): String {
        val n = s.length
        // Task 1-1
        val answer1 = (0..<n)
            .map { getLongestPalindromeFromMiddlePoint(s, it, it) }
            .maxBy { it.length }
        
        // Task 1-2
        val answer2 = (0..<n - 1)
            .filter { s[it] == s[it + 1] }
            .map { getLongestPalindromeFromMiddlePoint(s, it, it + 1) }
            .maxByOrNull { it.length } 
            ?: ""
        
        val answer = maxOf(answer1, answer2, Comparator.comparingInt { it.length })
        return answer
    }
    
    // Task 2-1
    fun getLongestPalindromeFromMiddlePoint(s: String, initialL: Int, initialR: Int): String {
        var l = initialL - 1
        var r = initialR + 1

        while (0 <= l && r < s.length && s[l] == s[r]) {
            l--
            r++
        }
        l++
        r--

        return s.substring(l, r + 1)
    }
}