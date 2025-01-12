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
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {

        var answer: ListNode? = null
        
        val pointers = lists
        var tail: ListNode? = ListNode(50_000)
        var isFirst = true
        while (pointers.any { it != null }) {
            
            var (i, v) = -1 to 50_000
            
            pointers.forEachIndexed { index, pointer ->
                pointer?.let {
                    if (pointer.`val` < v) {
                        i = index
                        v = pointer.`val`
                    }
                }
            }
            
            tail?.next = ListNode(v)
            pointers[i] = pointers[i]?.next

            if (isFirst) {
                answer = tail?.next
                isFirst = false
            }
            
            tail = tail?.next
        }
        
        return answer
    }
}