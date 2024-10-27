/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 *
 * Intuition:
 * 1. `val` : represents the digit in the node
 * 2. next : represents the next node (the former digit in decimal number, if it exists)
 *
 * Approach :
 * 1. iterate both two ListNode
 *  1) read each `val` of two node
 *  2) sum them and add temp variable to the sum, and reset the temp variable to 0.
 *  3) if the sum exceed 9, add 1 to temp variable and subtract 10 from the sum
 *  4) add new node with value of the sum, to the ListNode for return
 *  5) if two ListNode has no next node, finish the iteration
 *  6) if a ListNode has no next node, the part always indicate 0.
 * 2. After the iteration, if the temp variable's value is 1, add it as the final node of the return
 * 3. For simple implementation following the interface of the class ListNode, use stack for storing the values.
 *  - The pointer should be on the last digit of the result (sum of the two number)
 */
class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var p1 = l1
        var p2 = l2

        val stack = ArrayDeque<Int>()
        var temp = 0
        while (p1 != null || p2 != null) {
            val v1 = p1?.`val` ?: 0
            val v2 = p2?.`val` ?: 0

            var sum = v1 + v2 + temp
            temp = 0
            if (sum > 9) {
                temp = 1
                sum -= 10
            }

            stack.addLast(sum)

            p1 = p1?.next
            p2 = p2?.next
        }

        if (temp == 1) {
            stack.addLast(1)
        }

        var next: ListNode? = null
        while (stack.isNotEmpty()) {
            val cur = stack.removeLast()

            next = ListNode(cur).also {
                it.next = next
            }
        }

        return next
    }
}
