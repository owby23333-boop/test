package com.yuewen;

import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

/* JADX INFO: loaded from: classes17.dex */
public class tl4 {
    public static Document a(InputStream inputStream) {
        try {
            return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Document b(String str) {
        try {
            return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(str)));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Node c(Node node, String str) {
        if (!node.hasChildNodes()) {
            return null;
        }
        for (Node firstChild = node.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            if (firstChild.getNodeName().equals(str)) {
                return firstChild;
            }
        }
        return null;
    }

    public static Element d(Node node, String str) {
        Node nodeC = c(node, str);
        if (nodeC instanceof Element) {
            return (Element) nodeC;
        }
        return null;
    }

    public static int e(Node node, String str) {
        return Integer.valueOf(g(node, str)).intValue();
    }

    public static long f(Node node, String str) {
        return Long.valueOf(g(node, str)).longValue();
    }

    public static String g(Node node, String str) {
        Node nodeC = c(node, str);
        if (nodeC != null) {
            return nodeC.getTextContent();
        }
        return null;
    }

    public static boolean h(Node node, String str) {
        return d(node, str) != null;
    }

    public static Element i(Node node, String str) {
        Element elementCreateElement = node.getOwnerDocument().createElement(str);
        node.appendChild(elementCreateElement);
        return elementCreateElement;
    }

    public static Element j(Node node, String str, String str2) {
        Element elementI = i(node, str);
        elementI.setTextContent(str2);
        return elementI;
    }

    public static Element k(String str) {
        try {
            Document documentNewDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element elementCreateElement = documentNewDocument.createElement(str);
            documentNewDocument.appendChild(elementCreateElement);
            return elementCreateElement;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String l(Node node, String str, String str2) {
        String strG = g(node, str);
        return strG != null ? strG : str2;
    }

    public static String m(Node node) throws TransformerException {
        Transformer transformerNewTransformer = TransformerFactory.newInstance().newTransformer();
        StringWriter stringWriter = new StringWriter();
        transformerNewTransformer.transform(new DOMSource(node), new StreamResult(stringWriter));
        String string = stringWriter.toString();
        if (node instanceof Document) {
            return string;
        }
        Matcher matcher = Pattern.compile("\\<\\?.*\\?\\>(.*)", 32).matcher(string);
        return matcher.matches() ? matcher.group(1) : string;
    }
}
