/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        var answer = head
        repeat(k - 1) {
            answer = answer?.next
        }
        
        var prev = ListNode(-1) // Dummy node for simpler implementation
        var kFirst = head
        while (kFirst != null) {
            val stack = ArrayDeque<ListNode>()
            var kIter = kFirst
            repeat(k) {
                kIter?.let {
                    stack.addLast(it)
                    kIter = it.next
                }
            }
            if (stack.size < k) {
                prev.next = kFirst
                break
            }
            
            var stLast = stack.removeLast()
            prev.next = stLast
            while (stack.isNotEmpty()) {
                stLast.next = stack.last()
                stLast = stack.removeLast()
            }
            
            prev = stLast
            prev.next = null
            kFirst = kIter
        }
        
        return answer
    }
}