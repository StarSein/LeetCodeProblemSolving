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
    fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head == null) return null
        var prev: ListNode = head
        var cur: ListNode? = head.next
        while (cur != null) {
             if (prev.`val` == cur.`val`) {
                 prev.next = null
             } else {
                 prev.next = cur
                 prev = cur
             }
            cur = cur.next
        }
        return head
    }
}