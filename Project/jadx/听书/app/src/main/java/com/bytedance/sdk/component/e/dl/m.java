package com.bytedance.sdk.component.e.dl;

import android.util.Xml;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.sdk.component.utils.wp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes2.dex */
public class m implements com.bytedance.sdk.component.e.g, com.bytedance.sdk.component.e.z {
    private final boolean g;
    private final com.bytedance.sdk.component.a.g.z z;

    public m(com.bytedance.sdk.component.a.g.z zVar) {
        this.z = zVar;
        this.g = false;
    }

    public m(com.bytedance.sdk.component.a.g.z zVar, boolean z) {
        this.z = zVar;
        this.g = z;
    }

    @Override // com.bytedance.sdk.component.e.z
    public Map<String, Object> z(File file) throws Throwable {
        FileInputStream fileInputStream;
        HashMap map = new HashMap();
        if (!file.exists()) {
            return map;
        }
        if (!file.canRead()) {
            wp.g("XmlSimpleReader", "can't read file " + file);
            return map;
        }
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Exception unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
                xmlPullParserNewPullParser.setInput(fileInputStream, null);
                for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.next()) {
                    if (eventType == 2) {
                        String name = xmlPullParserNewPullParser.getName();
                        if (TypedValues.Custom.S_STRING.equals(name) || "int".equals(name) || "long".equals(name) || TypedValues.Custom.S_FLOAT.equals(name) || TypedValues.Custom.S_BOOLEAN.equals(name) || "set".equals(name)) {
                            String attributeValue = xmlPullParserNewPullParser.getAttributeValue(null, "name");
                            Object objZ = z(xmlPullParserNewPullParser, name);
                            if (attributeValue != null && objZ != null) {
                                map.put(attributeValue, objZ);
                            }
                        }
                    }
                }
                fileInputStream.close();
            } catch (Exception unused2) {
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                return new com.bytedance.sdk.component.e.z.g().z(map, this.z, this.g);
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (IOException unused4) {
        }
        return new com.bytedance.sdk.component.e.z.g().z(map, this.z, this.g);
    }

    private Object z(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        str.hashCode();
        switch (str) {
            case "string":
                return xmlPullParser.nextText();
            case "int":
                return Integer.valueOf(Integer.parseInt(xmlPullParser.getAttributeValue(null, "value")));
            case "set":
                return z(xmlPullParser);
            case "long":
                return Long.valueOf(Long.parseLong(xmlPullParser.getAttributeValue(null, "value")));
            case "boolean":
                return Boolean.valueOf(Boolean.parseBoolean(xmlPullParser.getAttributeValue(null, "value")));
            case "float":
                return Float.valueOf(Float.parseFloat(xmlPullParser.getAttributeValue(null, "value")));
            default:
                return null;
        }
    }

    private Set<String> z(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        HashSet hashSet = new HashSet();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 3 && "set".equals(xmlPullParser.getName())) {
                return hashSet;
            }
            if (eventType == 2 && TypedValues.Custom.S_STRING.equals(xmlPullParser.getName())) {
                hashSet.add(xmlPullParser.nextText());
            }
            eventType = xmlPullParser.next();
        }
    }

    private void z(String str, Object obj, XmlSerializer xmlSerializer) throws IOException {
        if (obj instanceof String) {
            xmlSerializer.startTag(null, TypedValues.Custom.S_STRING);
            xmlSerializer.attribute(null, "name", str);
            xmlSerializer.text(z((String) obj));
            xmlSerializer.endTag(null, TypedValues.Custom.S_STRING);
            return;
        }
        if (obj instanceof Integer) {
            z(str, (Integer) obj, xmlSerializer);
            return;
        }
        if (obj instanceof Long) {
            z(str, (Long) obj, xmlSerializer);
            return;
        }
        if (obj instanceof Float) {
            z(str, (Float) obj, xmlSerializer);
            return;
        }
        if (obj instanceof Double) {
            z(str, (Double) obj, xmlSerializer);
        } else if (obj instanceof Boolean) {
            z(str, (Boolean) obj, xmlSerializer);
        } else if (obj instanceof Set) {
            z(str, (Set<String>) obj, xmlSerializer);
        }
    }

    private void z(String str, Integer num, XmlSerializer xmlSerializer) throws IOException {
        xmlSerializer.startTag(null, "int");
        xmlSerializer.attribute(null, "name", str);
        xmlSerializer.attribute(null, "value", Integer.toString(num.intValue()));
        xmlSerializer.endTag(null, "int");
    }

    private void z(String str, Long l, XmlSerializer xmlSerializer) throws IOException {
        xmlSerializer.startTag(null, "long");
        xmlSerializer.attribute(null, "name", str);
        xmlSerializer.attribute(null, "value", Long.toString(l.longValue()));
        xmlSerializer.endTag(null, "long");
    }

    private void z(String str, Float f, XmlSerializer xmlSerializer) throws IOException {
        xmlSerializer.startTag(null, TypedValues.Custom.S_FLOAT);
        xmlSerializer.attribute(null, "name", str);
        xmlSerializer.attribute(null, "value", Float.toString(f.floatValue()));
        xmlSerializer.endTag(null, TypedValues.Custom.S_FLOAT);
    }

    private void z(String str, Double d, XmlSerializer xmlSerializer) throws IOException {
        xmlSerializer.startTag(null, "double");
        xmlSerializer.attribute(null, "name", str);
        xmlSerializer.attribute(null, "value", Double.toString(d.doubleValue()));
        xmlSerializer.endTag(null, "double");
    }

    private void z(String str, Boolean bool, XmlSerializer xmlSerializer) throws IOException {
        xmlSerializer.startTag(null, TypedValues.Custom.S_BOOLEAN);
        xmlSerializer.attribute(null, "name", str);
        xmlSerializer.attribute(null, "value", Boolean.toString(bool.booleanValue()));
        xmlSerializer.endTag(null, TypedValues.Custom.S_BOOLEAN);
    }

    private void z(String str, Set<String> set, XmlSerializer xmlSerializer) throws IOException {
        xmlSerializer.startTag(null, "set");
        xmlSerializer.attribute(null, "name", str);
        for (String str2 : set) {
            xmlSerializer.startTag(null, TypedValues.Custom.S_STRING);
            xmlSerializer.text(z(str2));
            xmlSerializer.endTag(null, TypedValues.Custom.S_STRING);
        }
        xmlSerializer.endTag(null, "set");
    }

    @Override // com.bytedance.sdk.component.e.g
    public void z(Map<String, Object> map, File file) throws Throwable {
        if (file == null) {
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException unused) {
        }
        Map<String, Object> mapG = new com.bytedance.sdk.component.e.z.g().g(map, this.z, this.g);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
                    xmlSerializerNewSerializer.setOutput(fileOutputStream2, "utf-8");
                    xmlSerializerNewSerializer.startDocument(null, Boolean.TRUE);
                    xmlSerializerNewSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
                    xmlSerializerNewSerializer.startTag(null, "map");
                    for (String str : mapG.keySet()) {
                        if (str != null) {
                            z(str, mapG.get(str), xmlSerializerNewSerializer);
                        }
                    }
                    xmlSerializerNewSerializer.endTag(null, "map");
                    xmlSerializerNewSerializer.endDocument();
                    try {
                        fileOutputStream2.close();
                    } catch (Exception unused2) {
                    }
                } catch (Exception e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    wp.g("XmlSimpleReader", "write file exception ", e);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused4) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    private String z(String str) {
        int i;
        StringBuilder sb = null;
        if (str == null) {
            return null;
        }
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            char cCharAt = str.charAt(i2);
            if ((cCharAt < ' ' || cCharAt > 55295) && !((cCharAt >= 57344 && cCharAt <= 65533) || cCharAt == '\t' || cCharAt == '\n' || cCharAt == '\r')) {
                if (sb == null) {
                    sb = new StringBuilder();
                    if (i2 > 0) {
                        sb.append(str.substring(0, i2));
                    }
                }
                if (cCharAt == '\"') {
                    sb.append("&quot;");
                } else if (cCharAt == '<') {
                    sb.append("&lt;");
                } else if (cCharAt == '>') {
                    sb.append("&gt;");
                } else if (cCharAt == '&') {
                    sb.append("&amp;");
                } else if (cCharAt == '\'') {
                    sb.append("&apos;");
                } else if (Character.isHighSurrogate(cCharAt) && (i = i2 + 1) < length) {
                    char cCharAt2 = str.charAt(i);
                    if (Character.isLowSurrogate(cCharAt2)) {
                        sb.append(cCharAt);
                        sb.append(cCharAt2);
                        i2 = i;
                    }
                } else {
                    sb.append("&#").append((int) cCharAt).append(";");
                }
            } else if (sb != null) {
                sb.append(cCharAt);
            }
            i2++;
        }
        return sb != null ? sb.toString() : str;
    }
}
