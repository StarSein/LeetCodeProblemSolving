/**

1. If the input is negative, the output should be false.
2. Using stack, compare all the pairs of the digits.

Time Complexity: O(N) (N is the length of the number)

 */
class Solution {

    val deque = ArrayDeque<Int>()

    fun isPalindrome(x: Int): Boolean {
        if (x < 0) {
            return false
        }
        
        var num = x
        while (num > 0) {
            deque.addLast(num % 10)
            num /= 10
        }
        
        while (deque.size > 1) {
            val first = deque.removeFirst()
            val last = deque.removeLast()
            
            if (first != last) {
                return false
            }
        }
        
        return true
    }
}