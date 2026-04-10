package com.xiaomi.push;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: loaded from: classes8.dex */
public class hn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static hn f8048a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Map<String, Object> f509a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, Object> f8049b = new ConcurrentHashMap();

    private hn() throws Throwable {
        m504a();
    }

    public static synchronized hn a() {
        if (f8048a == null) {
            f8048a = new hn();
        }
        return f8048a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m504a() throws Throwable {
        InputStream inputStreamOpenStream;
        try {
            for (ClassLoader classLoader : m502a()) {
                Enumeration<URL> resources = classLoader.getResources("META-INF/smack.providers");
                while (resources.hasMoreElements()) {
                    try {
                        inputStreamOpenStream = resources.nextElement().openStream();
                    } catch (Throwable th) {
                        th = th;
                        inputStreamOpenStream = null;
                    }
                    try {
                        XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
                        xmlPullParserNewPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                        xmlPullParserNewPullParser.setInput(inputStreamOpenStream, "UTF-8");
                        int eventType = xmlPullParserNewPullParser.getEventType();
                        do {
                            if (eventType == 2) {
                                if (xmlPullParserNewPullParser.getName().equals("iqProvider")) {
                                    xmlPullParserNewPullParser.next();
                                    xmlPullParserNewPullParser.next();
                                    String strNextText = xmlPullParserNewPullParser.nextText();
                                    xmlPullParserNewPullParser.next();
                                    xmlPullParserNewPullParser.next();
                                    String strNextText2 = xmlPullParserNewPullParser.nextText();
                                    xmlPullParserNewPullParser.next();
                                    xmlPullParserNewPullParser.next();
                                    String strNextText3 = xmlPullParserNewPullParser.nextText();
                                    String strA = a(strNextText, strNextText2);
                                    if (!this.f8049b.containsKey(strA)) {
                                        try {
                                            Class<?> cls = Class.forName(strNextText3);
                                            if (hl.class.isAssignableFrom(cls)) {
                                                this.f8049b.put(strA, cls.newInstance());
                                            } else if (he.class.isAssignableFrom(cls)) {
                                                this.f8049b.put(strA, cls);
                                            }
                                        } catch (ClassNotFoundException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                } else if (xmlPullParserNewPullParser.getName().equals("extensionProvider")) {
                                    xmlPullParserNewPullParser.next();
                                    xmlPullParserNewPullParser.next();
                                    String strNextText4 = xmlPullParserNewPullParser.nextText();
                                    xmlPullParserNewPullParser.next();
                                    xmlPullParserNewPullParser.next();
                                    String strNextText5 = xmlPullParserNewPullParser.nextText();
                                    xmlPullParserNewPullParser.next();
                                    xmlPullParserNewPullParser.next();
                                    String strNextText6 = xmlPullParserNewPullParser.nextText();
                                    String strA2 = a(strNextText4, strNextText5);
                                    if (!this.f509a.containsKey(strA2)) {
                                        try {
                                            Class<?> cls2 = Class.forName(strNextText6);
                                            if (hm.class.isAssignableFrom(cls2)) {
                                                this.f509a.put(strA2, cls2.newInstance());
                                            } else if (hh.class.isAssignableFrom(cls2)) {
                                                this.f509a.put(strA2, cls2);
                                            }
                                        } catch (ClassNotFoundException e2) {
                                            e2.printStackTrace();
                                        }
                                    }
                                }
                            }
                            eventType = xmlPullParserNewPullParser.next();
                        } while (eventType != 1);
                        inputStreamOpenStream.close();
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            inputStreamOpenStream.close();
                        } catch (Exception unused) {
                        }
                        throw th;
                    }
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Object m503a(String str, String str2) {
        return this.f509a.get(a(str, str2));
    }

    public void a(String str, String str2, Object obj) {
        if (!(obj instanceof hm) && !(obj instanceof Class)) {
            throw new IllegalArgumentException("Provider must be a PacketExtensionProvider or a Class instance.");
        }
        this.f509a.put(a(str, str2), obj);
    }

    private String a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(str);
        sb.append("/>");
        if (str != null) {
            sb.append("<");
            sb.append(str2);
            sb.append("/>");
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private ClassLoader[] m502a() {
        ClassLoader[] classLoaderArr = {hn.class.getClassLoader(), Thread.currentThread().getContextClassLoader()};
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 2; i++) {
            ClassLoader classLoader = classLoaderArr[i];
            if (classLoader != null) {
                arrayList.add(classLoader);
            }
        }
        return (ClassLoader[]) arrayList.toArray(new ClassLoader[arrayList.size()]);
    }
}
