import kotlin.math.min

/**
 *
 * dp[i][j]: the minimum number of operations
 *           required to convert word1[0:i] to word2[0:j]
 *
 * Time Complexity: O(N^2)
 * Space Complexity: O(N^2)
 *
 */

class Solution {

    fun minDistance(word1: String, word2: String): Int {

        val cache = Array(word1.length + 1) { IntArray(word2.length + 1) }

        for (i in 0..word1.length) {
            for (j in 0..word2.length) {
                if (i == 0 && j == 0) {
                    continue
                }

                val list = mutableListOf<Int>()

                if (i > 0 && j > 0) {
                    if (word1[i - 1] == word2[j - 1]) {
                        list.add(cache[i - 1][j - 1])
                    } else {
                        // Replace a character
                        list.add(cache[i - 1][j - 1] + 1)
                    }
                }
                if (i > 0) {
                    // Delete a character
                    list.add(cache[i - 1][j] + 1)
                }
                if (j > 0) {
                    // Insert a character
                    list.add(cache[i][j - 1] + 1)
                }

                cache[i][j] = list.min()
            }
        }

        return cache[word1.length][word2.length]
    }
}