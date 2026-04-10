package androidx.test.novelreader.parser

import java.io.InputStream

object TxtParser {

    private val SENTENCE_SPLIT = Regex("(?<=[。！？.!?\\n])")

    fun parse(inputStream: InputStream): BookContent {
        val fullText = inputStream.bufferedReader().readText()
        val sentences = fullText
            .split(SENTENCE_SPLIT)
            .map { it.trim() }
            .filter { it.isNotEmpty() }

        val chapters = detectChapters(fullText)

        return BookContent(
            fullText = fullText,
            sentences = sentences,
            chapters = chapters
        )
    }

    private fun detectChapters(text: String): List<Chapter> {
        val chapterPattern = Regex("^\\s*(第[一二三四五六七八九十百千万零\\d]+[章节回卷集].*)", RegexOption.MULTILINE)
        val matches = chapterPattern.findAll(text).toList()
        if (matches.isEmpty()) return emptyList()

        return matches.mapIndexed { index, match ->
            val start = match.range.first
            val end = if (index < matches.size - 1) matches[index + 1].range.first else text.length
            Chapter(
                title = match.groupValues[1].trim(),
                startCharIndex = start,
                content = text.substring(start, end).trim()
            )
        }
    }
}
