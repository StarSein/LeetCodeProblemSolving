import kotlin.math.min

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
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null && list2 == null) {
            return null
        } else if (list1 == null) {
            return list2
        } else if (list2 == null) {
            return list1
        } else {
            var t1 = list1
            var t2 = list2

            val answer: ListNode?
            if (t1.`val` >= t2.`val`) {
                answer = ListNode(t2.`val`)
                t2 = t2.next
            } else {
                answer = ListNode(t1.`val`)
                t1 = t1.next
            }
            var tail = answer

            while (t1 != null || t2 != null) {
                if (t1 != null && t2 != null) {
                    if (t1.`val` >= t2.`val`) {
                        tail?.next = ListNode(t2.`val`)
                        t2 = t2.next
                    } else {
                        tail?.next = ListNode(t1.`val`)
                        t1 = t1.next
                    }
                } else if (t1 != null) {
                    tail?.next = ListNode(t1.`val`)
                    t1 = t1.next
                } else if (t2 != null) {
                    tail?.next = ListNode(t2.`val`)
                    t2 = t2.next
                }
                tail = tail?.next
            }

            return answer
        }
    }
}