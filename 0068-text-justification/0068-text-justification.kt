/**
 *
 * 1. Classify words into lines so that each line doesn't exceed the max width.
 * 2. Calculate and distribute spare empty spaces
 *
 */


class Solution {

    data class Line(
        val words: List<String>,
        val spareSpaceLength: Int
    )

    fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {

        val lines = mutableListOf<Line>()

        var currentWords = mutableListOf<String>()
        var currentLineLength = 0
        words.forEach { word ->
            if (currentLineLength > 0) {
                if (currentLineLength + 1 + word.length > maxWidth) {
                    lines.add(
                        Line(
                            currentWords.toList(),
                            maxWidth - currentLineLength
                        )
                    )
                    currentWords.clear()
                    currentLineLength = 0
                } else {
                    currentLineLength++
                }
            }
            currentWords.add(word)
            currentLineLength += word.length
        }
        lines.add(
            Line(
                currentWords.toList(),
                maxWidth - currentLineLength
            )
        )

        val answer = lines.mapIndexed { index, (words, spareSpaceLength) ->
            val sb = StringBuilder()
            if (index == lines.lastIndex || words.size == 1) {
                val prefix = words.joinToString(" ")
                sb.append(prefix)
                repeat(maxWidth - prefix.length) {
                    sb.append(" ")
                }
                sb.toString()
            } else {
                val emptySpaceCount = words.size - 1
                val div = spareSpaceLength / emptySpaceCount
                val mod = spareSpaceLength % emptySpaceCount

                sb.append(words[0])
                repeat(emptySpaceCount) {
                    val emptySpaceLength = if (it < mod) div + 2
                                           else div + 1
                    repeat(emptySpaceLength) {
                        sb.append(" ")
                    }
                    sb.append(words[it + 1])
                }
                sb.toString()
            }
        }

        return answer
    }
}