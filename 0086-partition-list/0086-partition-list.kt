/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 *
 * ex1)
 * 1 - 4 - 3 - '2' - 5 - 2
 * 1 - '2' - 4 - 3 - 5 - 2
 *
 * 1 - 2 - 4 - 3 - 5 - '2'
 * 1 - 2 - '2' - 4 - 3 - 5
 *
 * Suppose 'y' is the first node that has a value greater than or equal to 'x'.
 * All nodes that have a value less than 'x' should take place right in front of 'y'.
 *
 */
class Solution {
    fun partition(head: ListNode?, x: Int): ListNode? {
        val dummy: ListNode = ListNode(-201)
            .apply { next = head }
        var iter = dummy
        var pivot: ListNode? = null
        while (iter.next != null) {
            iter.next?.let { nextNode ->
                if (pivot == null) {
                    if (nextNode.`val` >= x) {
                        pivot = iter
                    }
                    iter = nextNode
                } else {
                    if (nextNode.`val` < x) {
                        iter.next = nextNode.next
                        nextNode.next = pivot.next
                        pivot.next = nextNode
                        pivot = pivot.next
                    } else {
                        iter = nextNode
                    }
                }
            }
        }
        return dummy.next
    }
}