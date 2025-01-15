/**
 * 
 * 1. When applying naive approach of brute-force, 
 *    Time Complexity is O(W * (S - W))
 *    ( W: words.sumOf { it.length }
 *      S: s.length )
 * 2. The worst case is like this.
 *  1) S == 10_000
 *  2) W == 5_000
 * 3. It seems enough to fit the time constraint, even if the case is worst.
 * 
 */

class Solution {
    fun findSubstring(s: String, words: Array<String>): List<Int> {
        // initialize answer
        val answer = mutableListOf<Int>()
        
        // count the number of each word to make a map for retrieving the number of each word
        val numbers = mutableMapOf<String, Int>()
        for (word in words) {
            numbers[word] = numbers.getOrDefault(word, 0) + 1
        }
        
        // looping all indices of s and marking each of them as a starting index,
        // check whether the interval of length W contains all words
        // if true, add the starting index to answer
        val wordNum = words.size
        val wordLength = words[0].length
        val w = wordNum * wordLength
        val end = s.length - w
        for (i in 0..end) {
            var j = i
            val counts = mutableMapOf<String, Int>()
            var isConcatenation = true
            repeat(wordNum) { 
                val l = j + wordLength * it
                val r = l + wordLength
                val word = s.substring(l, r)
                if (!numbers.containsKey(word)) {
                    isConcatenation = false
                    return@repeat
                }
                counts[word] = (counts.getOrDefault(word, 0) + 1).also { count ->
                    if (count > (numbers[word] ?: 0)) {
                        isConcatenation = false
                        return@repeat
                    }
                }
            }
            if (isConcatenation) {
                answer.add(i)
            }
        }
        
        // return answer
        return answer
    }
}