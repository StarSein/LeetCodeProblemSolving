class Solution {
    fun strStr(haystack: String, needle: String): Int {
        for (i in haystack.indices) {
            var match = true
            for (j in needle.indices) {
                if (i + j >= haystack.length
                    || haystack[i + j] != needle[j]) {
                    match = false
                    break
                }
            }
            if (match) {
                return i
            }
        }

        return -1
    }
}