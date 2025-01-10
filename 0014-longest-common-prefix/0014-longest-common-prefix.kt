class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        
        val answer = StringBuilder()
        
        var index = 0
        while (true) {
            val target = strs[0].getOrNull(index) ?: break
            
            if (strs.any { str ->
                str.length == index || str[index] != target}) {
                break
            }
            
            answer.append(target)

            index++
        }
        
        return answer.toString()
    }
}