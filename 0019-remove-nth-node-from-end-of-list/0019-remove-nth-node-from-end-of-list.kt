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
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        // iterating head, count the number of nodes
        var ptr = head
        var cnt = 0
        while (ptr != null) {
            cnt++
            ptr = ptr.next
        }

        // return a new head, except for the (number - n)th node
        val tgt = cnt - n
        if (tgt == 0) {
            return head?.next
        }
        
        ptr = head
        repeat(tgt - 1) {
            ptr?.let {
                ptr = it.next
            }
        }
        ptr?.next = ptr?.next?.next
        return head
    }
}