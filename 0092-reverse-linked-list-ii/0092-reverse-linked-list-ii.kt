/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

/**
 * 
 * 1. head: 링크드 리스트의 헤드 포인터
 * 2. inHead: 반전된 리스트의 헤드 포인터
 * 3. inTail: 반전된 리스트의 꼬리 포인터
 * 4. inTailNext: inTail의 next 노드를 가리키는 포인터
 * 
 * 1. 더미 노드를 헤드 앞에 둔다
 * 2. 폐구간 [left, right]의 노드들을 순서대로 스택에 담는다
 *    스택의 최상단 원소를 (left-1)번째 노드의 next 노드로 만든다
 *    스택에서 원소를 추출하면서 직전에 추출한 노드의 next 노드로 만든다
 *    스택의 최하단 원소의 next에 (right+1)번째 노드를 할당한다
 * 3. 더미 노드의 next 노드를 헤드로 삼는다
 * 
 */

class Solution {
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        val dummy = ListNode(-1)
        dummy.next = head
        
        var ptr: ListNode? = dummy
        var prefix: ListNode? = null
        repeat(left) {
            prefix = ptr
            ptr = ptr?.next
        }
        
        val st = ArrayDeque<ListNode?>()
        repeat(right - left + 1) {
            st.addLast(ptr)
            ptr = ptr?.next
        }
        
        val suffix = ptr
        prefix?.next = st.last()
        while (st.size > 1) {
            st.removeLast()?.next = st.last()
        }
        st.removeLast()?.next = suffix
        
        return dummy.next
    }
}