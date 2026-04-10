package androidx.test.novelreader.parser

import org.w3c.dom.Element
import org.w3c.dom.Node
import java.io.InputStream
import java.util.zip.ZipInputStream
import javax.xml.parsers.DocumentBuilderFactory

object EpubParser {

    private val HTML_TAG_REGEX = Regex("<[^>]*>")

    fun parse(inputStream: InputStream): BookContent {
        val files = mutableMapOf<String, ByteArray>()
        ZipInputStream(inputStream).use { zip ->
            var entry = zip.nextEntry
            while (entry != null) {
                if (!entry.isDirectory) {
                    files[entry.name] = zip.readBytes()
                }
                entry = zip.nextEntry
            }
        }

        val opfPath = findOpfPath(files) ?: return fallbackParse(files)
        val opfDir = opfPath.substringBeforeLast("/", "")
        val opfContent = files[opfPath] ?: return fallbackParse(files)

        val spineItems = parseOpfSpine(opfContent, opfDir)

        val chapters = mutableListOf<Chapter>()
        val fullTextBuilder = StringBuilder()

        for (itemPath in spineItems) {
            val content = files[itemPath] ?: continue
            val text = stripHtml(String(content, Charsets.UTF_8))
            if (text.isBlank()) continue

            val chapterTitle = extractTitle(String(content, Charsets.UTF_8)) ?: "Chapter ${chapters.size + 1}"
            chapters.add(
                Chapter(
                    title = chapterTitle,
                    startCharIndex = fullTextBuilder.length,
                    content = text
                )
            )
            if (fullTextBuilder.isNotEmpty()) fullTextBuilder.append("\n\n")
            fullTextBuilder.append(text)
        }

        val fullText = fullTextBuilder.toString()
        if (fullText.isBlank()) return fallbackParse(files)

        val sentences = fullText
            .split(Regex("(?<=[。！？.!?\\n])"))
            .map { it.trim() }
            .filter { it.isNotEmpty() }

        return BookContent(fullText = fullText, sentences = sentences, chapters = chapters)
    }

    private fun findOpfPath(files: Map<String, ByteArray>): String? {
        val containerXml = files["META-INF/container.xml"] ?: return null
        return try {
            val doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                .parse(containerXml.inputStream())
            val rootFiles = doc.getElementsByTagName("rootfile")
            if (rootFiles.length > 0) {
                (rootFiles.item(0) as Element).getAttribute("full-path")
            } else null
        } catch (e: Exception) {
            null
        }
    }

    private fun parseOpfSpine(opfContent: ByteArray, opfDir: String): List<String> {
        return try {
            val doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                .parse(opfContent.inputStream())

            val manifestItems = mutableMapOf<String, String>()
            val manifest = doc.getElementsByTagName("item")
            for (i in 0 until manifest.length) {
                val element = manifest.item(i) as Element
                val id = element.getAttribute("id")
                val href = element.getAttribute("href")
                if (id.isNotEmpty() && href.isNotEmpty()) {
                    val fullPath = if (opfDir.isNotEmpty()) "$opfDir/$href" else href
                    manifestItems[id] = fullPath
                }
            }

            val spineRefs = mutableListOf<String>()
            val spine = doc.getElementsByTagName("itemref")
            for (i in 0 until spine.length) {
                val element = spine.item(i) as Element
                val idref = element.getAttribute("idref")
                manifestItems[idref]?.let { spineRefs.add(it) }
            }
            spineRefs
        } catch (e: Exception) {
            emptyList()
        }
    }

    private fun extractTitle(html: String): String? {
        return try {
            val doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                .parse(html.byteInputStream())
            val titles = doc.getElementsByTagName("title")
            if (titles.length > 0) {
                val text = titles.item(0).textContent?.trim()
                if (!text.isNullOrBlank()) text else null
            } else {
                val h1s = doc.getElementsByTagName("h1")
                if (h1s.length > 0) h1s.item(0).textContent?.trim() else null
            }
        } catch (e: Exception) {
            null
        }
    }

    private fun stripHtml(html: String): String {
        return html
            .replace(Regex("<br\\s*/?>", RegexOption.IGNORE_CASE), "\n")
            .replace(Regex("</p>", RegexOption.IGNORE_CASE), "\n")
            .replace(Regex("</div>", RegexOption.IGNORE_CASE), "\n")
            .replace(Regex("</h[1-6]>", RegexOption.IGNORE_CASE), "\n")
            .replace(HTML_TAG_REGEX, "")
            .replace(Regex("&nbsp;"), " ")
            .replace(Regex("&amp;"), "&")
            .replace(Regex("&lt;"), "<")
            .replace(Regex("&gt;"), ">")
            .replace(Regex("&quot;"), "\"")
            .replace(Regex("&#\\d+;")) { match ->
                val code = match.value.drop(2).dropLast(1).toIntOrNull()
                if (code != null) String(Character.toChars(code)) else ""
            }
            .replace(Regex("\n{3,}"), "\n\n")
            .trim()
    }

    private fun fallbackParse(files: Map<String, ByteArray>): BookContent {
        val textBuilder = StringBuilder()
        files.entries
            .filter { it.key.endsWith(".html") || it.key.endsWith(".xhtml") || it.key.endsWith(".htm") }
            .sortedBy { it.key }
            .forEach { (_, content) ->
                val text = stripHtml(String(content, Charsets.UTF_8))
                if (text.isNotBlank()) {
                    if (textBuilder.isNotEmpty()) textBuilder.append("\n\n")
                    textBuilder.append(text)
                }
            }

        val fullText = textBuilder.toString()
        val sentences = fullText
            .split(Regex("(?<=[。！？.!?\\n])"))
            .map { it.trim() }
            .filter { it.isNotEmpty() }

        return BookContent(fullText = fullText, sentences = sentences)
    }
}
