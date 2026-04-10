package androidx.test.novelreader.ui.reader

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.test.novelreader.parser.BookContent
import androidx.test.novelreader.ui.theme.TtsHighlightYellow
import androidx.test.novelreader.ui.theme.TtsHighlightYellowDark

@Composable
fun ReaderContent(
    content: BookContent,
    fontSize: Float,
    highlightSentenceIndex: Int,
    scrollState: ScrollState,
    isDarkTheme: Boolean,
    modifier: Modifier = Modifier
) {
    val highlightColor = if (isDarkTheme) TtsHighlightYellowDark else TtsHighlightYellow
    val textColor = MaterialTheme.colorScheme.onSurface

    val annotatedText: AnnotatedString = remember(content.fullText, highlightSentenceIndex, isDarkTheme) {
        if (highlightSentenceIndex < 0 || highlightSentenceIndex >= content.sentences.size) {
            AnnotatedString(content.fullText)
        } else {
            val sentence = content.sentences[highlightSentenceIndex]
            val startIndex = findSentencePosition(content.fullText, content.sentences, highlightSentenceIndex)
            if (startIndex >= 0) {
                buildAnnotatedString {
                    append(content.fullText.substring(0, startIndex))
                    withStyle(SpanStyle(background = highlightColor)) {
                        append(content.fullText.substring(startIndex, (startIndex + sentence.length).coerceAtMost(content.fullText.length)))
                    }
                    val endIdx = (startIndex + sentence.length).coerceAtMost(content.fullText.length)
                    if (endIdx < content.fullText.length) {
                        append(content.fullText.substring(endIdx))
                    }
                }
            } else {
                AnnotatedString(content.fullText)
            }
        }
    }

    Text(
        text = annotatedText,
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(horizontal = 20.dp, vertical = 16.dp),
        fontSize = fontSize.sp,
        lineHeight = (fontSize * 1.8f).sp,
        color = textColor,
        style = MaterialTheme.typography.bodyLarge
    )
}

private fun findSentencePosition(fullText: String, sentences: List<String>, targetIndex: Int): Int {
    var searchFrom = 0
    for (i in 0..targetIndex) {
        val sentence = sentences.getOrNull(i) ?: return -1
        val pos = fullText.indexOf(sentence, searchFrom)
        if (pos < 0) return -1
        if (i == targetIndex) return pos
        searchFrom = pos + sentence.length
    }
    return -1
}
