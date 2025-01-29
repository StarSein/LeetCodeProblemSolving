/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 *
 * 1. Calculate X (X: the length of the linked list)
 * 2. Rotate right the linked list Y times (Y = k % X, if Y == 0, Y = X)
 *    1) set head on (X - Y)-th node (0-based)
 *    2) if headIndex > 0, (headIndex = X - Y)
 *      cut and move a sublist in the range of [0, headIndex-1]
 *      next to the (X-1)-th node
 */


class Solution {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (head == null) {
            return null
        }
        
        val x = calculateLength(head)

        val y = (k % x).let { if (it == 0) x else it }
        val headIndex = x - y
        if (headIndex == 0) {
            return head
        }

        val leftNodeToNewHead = getNodeAt(head, headIndex - 1)
        val newHead = getNodeAt(leftNodeToNewHead, 1)
        val oldTail = getNodeAt(newHead, x - 1 - headIndex)

        leftNodeToNewHead?.next = null
        oldTail?.next = head
        return newHead
    }

    fun calculateLength(head: ListNode?): Int {
        var x = 0
        var pointer = head
        while (pointer != null) {
            x++
            pointer = pointer.next
        }
        return x
    }

    fun getNodeAt(head: ListNode?, index: Int): ListNode? {
        var pointer = head
        repeat(index) {
            pointer = pointer?.next
        }
        return pointer
    }
}