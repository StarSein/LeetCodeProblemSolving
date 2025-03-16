/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 *
 * 1. At first iteration, determine whether each value will be removed.
 *    - store at a mutableSet.
 * 2. At second iteration, remove all nodes which is marked
 *    - connect leaving numbers
 */
class Solution {

    val removalSet = mutableSetOf<Int>()

    fun deleteDuplicates(head: ListNode?): ListNode? {
        var ptr = head
        var prevVal = -101
        while (ptr != null) {
            if (prevVal == ptr.`val`) {
                removalSet.add(prevVal)
            }
            prevVal = ptr.`val`
            ptr = ptr.next
        }

        val newHead = ListNode(-101)
        var prevNode = newHead
        ptr = head
        while (ptr != null) {
            if (removalSet.contains(ptr.`val`)) {
                prevNode.next = null
            } else {
                prevNode.next = ptr
                prevNode = ptr
            }
            ptr = ptr.next
        }

        return newHead.next
    }
}