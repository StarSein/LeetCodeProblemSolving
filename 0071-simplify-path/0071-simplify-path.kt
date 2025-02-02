/**
 *
 * Use mutableList to store directory or file names which are separated by '/' in the answer.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */


class Solution {
    fun simplifyPath(path: String): String {
        val canonicalNames = mutableListOf<String>()

        val absoluteNames = path.split("/")
            .filter { it.isNotEmpty() }
            .forEach { absoluteName ->
                when (absoluteName) {
                    "." -> { }
                    ".." -> {
                        if (canonicalNames.isNotEmpty()) {
                            canonicalNames.removeLast()
                        }
                    }
                    else -> {
                        canonicalNames.add(absoluteName)
                    }
                }
            }

        return if (canonicalNames.isEmpty()) "/"
        else "/" + canonicalNames.joinToString("/")
    }
}
