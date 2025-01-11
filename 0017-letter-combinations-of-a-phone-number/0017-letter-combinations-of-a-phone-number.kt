class Solution {

    val letters = listOf(
        "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    )
    lateinit var comb: Array<Char>
    val answer = mutableListOf<String>()

    fun letterCombinations(digits: String): List<String> {
        if (digits == "") {
            return emptyList()
        }

        comb = Array(digits.length) { ' ' }

        recur(digits, 0)

        return answer
    }

    fun recur(digits: String, idx: Int) {
        if (idx == digits.length) {
            answer.add(comb.joinToString(""))
            return
        }

        val digit = digits[idx]
        val letter = letters[digit - '2']
        for (c in letter) {
            comb[idx] = c
            recur(digits, idx + 1)
        }
    }
}