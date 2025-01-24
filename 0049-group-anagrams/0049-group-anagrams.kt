class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {

        val map = mutableMapOf<List<Int>, MutableList<String>>()

        strs.forEach { str ->
            val counter = IntArray(26) { 0 }
            str.forEach { c ->
                counter[c - 'a']++
            }
            
            val key = counter.toList()

            if (map.containsKey(key)) {
                map[key]?.add(str)
            } else {
                map[key] = mutableListOf(str)
            }
        }

        return map.values.toList()
    }
}