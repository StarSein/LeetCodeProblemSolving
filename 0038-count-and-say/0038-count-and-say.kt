class Solution {
    fun countAndSay(n: Int): String {
        return cas(n)
    }

    fun cas(n: Int): String {
        if (n == 1) {
            return "1"
        }
        val res = cas(n - 1)
        val sb = StringBuilder()
        var prev = res[0]
        var cnt = 1
        for (i in 1 until res.length) {
            val cur = res[i]
            if (prev == cur) {
                cnt++
            } else {
                sb.append(cnt).append(prev)
                prev = cur
                cnt = 1
            }
        }
        sb.append(cnt).append(prev)
        return sb.toString()
    }
}