package org.json.alipay;

import com.alibaba.android.arouter.utils.Consts;
import com.yuewen.eq2;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f21193a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map f21194b;

    public static final class a {
        private a() {
        }

        public final Object clone() {
            return this;
        }

        public boolean equals(Object obj) {
            return obj == null || obj == this;
        }

        public String toString() {
            return eq2.g;
        }
    }

    public b() {
        this.f21194b = new HashMap();
    }

    public static String b(Object obj) {
        return (obj == null || obj.equals(null)) ? eq2.g : obj instanceof Number ? a((Number) obj) : ((obj instanceof Boolean) || (obj instanceof b) || (obj instanceof org.json.alipay.a)) ? obj.toString() : obj instanceof Map ? new b((Map) obj).toString() : obj instanceof Collection ? new org.json.alipay.a((Collection) obj).toString() : obj.getClass().isArray() ? new org.json.alipay.a(obj).toString() : d(obj.toString());
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:17:0x0034. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String d(java.lang.String r8) {
        /*
            if (r8 == 0) goto La6
            int r0 = r8.length()
            if (r0 != 0) goto La
            goto La6
        La:
            int r0 = r8.length()
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            int r2 = r0 + 4
            r1.<init>(r2)
            r2 = 34
            r1.append(r2)
            r3 = 0
            r4 = r3
        L1c:
            if (r3 >= r0) goto L9e
            char r5 = r8.charAt(r3)
            r6 = 12
            if (r5 == r6) goto L96
            r6 = 13
            if (r5 == r6) goto L93
            r6 = 92
            if (r5 == r2) goto L8c
            r7 = 47
            if (r5 == r7) goto L88
            if (r5 == r6) goto L8c
            switch(r5) {
                case 8: goto L82;
                case 9: goto L7f;
                case 10: goto L7c;
                default: goto L37;
            }
        L37:
            r4 = 32
            if (r5 < r4) goto L4b
            r4 = 128(0x80, float:1.8E-43)
            if (r5 < r4) goto L43
            r4 = 160(0xa0, float:2.24E-43)
            if (r5 < r4) goto L4b
        L43:
            r4 = 8192(0x2000, float:1.148E-41)
            if (r5 < r4) goto L8f
            r4 = 8448(0x2100, float:1.1838E-41)
            if (r5 >= r4) goto L8f
        L4b:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "000"
            r4.append(r6)
            java.lang.String r6 = java.lang.Integer.toHexString(r5)
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "\\u"
            r6.append(r7)
            int r7 = r4.length()
            int r7 = r7 + (-4)
            java.lang.String r4 = r4.substring(r7)
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            goto L84
        L7c:
            java.lang.String r4 = "\\n"
            goto L84
        L7f:
            java.lang.String r4 = "\\t"
            goto L84
        L82:
            java.lang.String r4 = "\\b"
        L84:
            r1.append(r4)
            goto L99
        L88:
            r7 = 60
            if (r4 != r7) goto L8f
        L8c:
            r1.append(r6)
        L8f:
            r1.append(r5)
            goto L99
        L93:
            java.lang.String r4 = "\\r"
            goto L84
        L96:
            java.lang.String r4 = "\\f"
            goto L84
        L99:
            int r3 = r3 + 1
            r4 = r5
            goto L1c
        L9e:
            r1.append(r2)
            java.lang.String r8 = r1.toString()
            return r8
        La6:
            java.lang.String r8 = "\"\""
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.json.alipay.b.d(java.lang.String):java.lang.String");
    }

    public Object a(String str) throws JSONException {
        Object objC = c(str);
        if (objC != null) {
            return objC;
        }
        throw new JSONException("JSONObject[" + d(str) + "] not found.");
    }

    public Object c(String str) {
        if (str == null) {
            return null;
        }
        return this.f21194b.get(str);
    }

    public Object e(String str) {
        return this.f21194b.remove(str);
    }

    public String toString() {
        try {
            Iterator itA = a();
            StringBuffer stringBuffer = new StringBuffer("{");
            while (itA.hasNext()) {
                if (stringBuffer.length() > 1) {
                    stringBuffer.append(',');
                }
                Object next = itA.next();
                stringBuffer.append(d(next.toString()));
                stringBuffer.append(':');
                stringBuffer.append(b(this.f21194b.get(next)));
            }
            stringBuffer.append('}');
            return stringBuffer.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public b(String str) {
        this(new c(str));
    }

    public static String a(Number number) throws JSONException {
        if (number == null) {
            throw new JSONException("Null pointer");
        }
        a((Object) number);
        String string = number.toString();
        if (string.indexOf(46) <= 0 || string.indexOf(101) >= 0 || string.indexOf(69) >= 0) {
            return string;
        }
        while (string.endsWith("0")) {
            string = string.substring(0, string.length() - 1);
        }
        return string.endsWith(Consts.DOT) ? string.substring(0, string.length() - 1) : string;
    }

    public boolean b(String str) {
        return this.f21194b.containsKey(str);
    }

    public b(Map map) {
        this.f21194b = map == null ? new HashMap() : map;
    }

    public Iterator a() {
        return this.f21194b.keySet().iterator();
    }

    public b(c cVar) throws JSONException {
        this();
        if (cVar.c() != '{') {
            throw cVar.a("A JSONObject text must begin with '{'");
        }
        while (true) {
            char c = cVar.c();
            if (c == 0) {
                throw cVar.a("A JSONObject text must end with '}'");
            }
            if (c == '}') {
                return;
            }
            cVar.a();
            String string = cVar.d().toString();
            char c2 = cVar.c();
            if (c2 == '=') {
                if (cVar.b() != '>') {
                    cVar.a();
                }
            } else if (c2 != ':') {
                throw cVar.a("Expected a ':' after a key");
            }
            a(string, cVar.d());
            char c3 = cVar.c();
            if (c3 != ',' && c3 != ';') {
                if (c3 != '}') {
                    throw cVar.a("Expected a ',' or '}'");
                }
                return;
            } else if (cVar.c() == '}') {
                return;
            } else {
                cVar.a();
            }
        }
    }

    public b a(String str, Object obj) throws JSONException {
        if (str == null) {
            throw new JSONException("Null key.");
        }
        if (obj != null) {
            a(obj);
            this.f21194b.put(str, obj);
        } else {
            e(str);
        }
        return this;
    }

    public static void a(Object obj) throws JSONException {
        if (obj != null) {
            if (obj instanceof Double) {
                Double d = (Double) obj;
                if (d.isInfinite() || d.isNaN()) {
                    throw new JSONException("JSON does not allow non-finite numbers.");
                }
                return;
            }
            if (obj instanceof Float) {
                Float f = (Float) obj;
                if (f.isInfinite() || f.isNaN()) {
                    throw new JSONException("JSON does not allow non-finite numbers.");
                }
            }
        }
    }
}
