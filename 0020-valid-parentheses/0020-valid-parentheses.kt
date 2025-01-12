class Solution {

    fun isValid(s: String): Boolean {

        val stack = ArrayDeque<Char>()
        val pairs = mapOf(
            ')' to '(',
            '}' to '{',
            ']' to '['
        )

        for (c in s) {
            when (c) {
                '(', '{', '[' -> stack.add(c)
                else -> {
                    if (stack.isEmpty() || pairs[c] != stack.removeLast()) {
                        return false
                    }
                }
            }
        }

        return stack.isEmpty()
    }
}