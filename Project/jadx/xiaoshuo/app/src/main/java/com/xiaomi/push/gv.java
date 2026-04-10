package com.xiaomi.push;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: loaded from: classes8.dex */
public final class gv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f8017a = 5000;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static Vector<String> f482a = new Vector<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f8018b = 330000;
    private static int c = 600000;
    private static int d = 330000;

    static {
        try {
            for (ClassLoader classLoader : m489a()) {
                Enumeration<URL> resources = classLoader.getResources("META-INF/smack-config.xml");
                while (resources.hasMoreElements()) {
                    InputStream inputStreamOpenStream = null;
                    try {
                        try {
                            inputStreamOpenStream = resources.nextElement().openStream();
                            XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
                            xmlPullParserNewPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                            xmlPullParserNewPullParser.setInput(inputStreamOpenStream, "UTF-8");
                            int eventType = xmlPullParserNewPullParser.getEventType();
                            do {
                                if (eventType == 2) {
                                    if (xmlPullParserNewPullParser.getName().equals("className")) {
                                        a(xmlPullParserNewPullParser);
                                    } else if (xmlPullParserNewPullParser.getName().equals("packetReplyTimeout")) {
                                        f8017a = a(xmlPullParserNewPullParser, f8017a);
                                    } else if (xmlPullParserNewPullParser.getName().equals("keepAliveInterval")) {
                                        f8018b = a(xmlPullParserNewPullParser, f8018b);
                                    } else if (xmlPullParserNewPullParser.getName().equals("mechName")) {
                                        f482a.add(xmlPullParserNewPullParser.nextText());
                                    }
                                }
                                eventType = xmlPullParserNewPullParser.next();
                            } while (eventType != 1);
                        } catch (Throwable th) {
                            try {
                                inputStreamOpenStream.close();
                            } catch (Exception unused) {
                            }
                            throw th;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        inputStreamOpenStream.close();
                    } catch (Exception unused2) {
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private gv() {
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static String m488a() {
        return "3.1.0";
    }

    public static int b() {
        return c;
    }

    public static int a() {
        return f8018b;
    }

    private static void a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String strNextText = xmlPullParser.nextText();
        try {
            Class.forName(strNextText);
        } catch (ClassNotFoundException unused) {
            System.err.println("Error! A startup class specified in smack-config.xml could not be loaded: " + strNextText);
        }
    }

    private static int a(XmlPullParser xmlPullParser, int i) {
        try {
            return Integer.parseInt(xmlPullParser.nextText());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return i;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static ClassLoader[] m489a() {
        ClassLoader[] classLoaderArr = {gv.class.getClassLoader(), Thread.currentThread().getContextClassLoader()};
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
