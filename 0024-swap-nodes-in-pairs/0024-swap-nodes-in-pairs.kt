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
    fun swapPairs(head: ListNode?): ListNode? {
        val answer = head?.next ?: head
        
        var prev = ListNode(0) // Dummy node for simpler implementation
        var cur = head

        while (cur != null) {
            val next = cur.next

            if (next == null) {
                prev.next = cur
                break
            }

            prev.next = next
            val temp = next.next
            next.next = cur
            cur.next = null
            prev = cur
            cur = temp
        }

        return answer
    }
}