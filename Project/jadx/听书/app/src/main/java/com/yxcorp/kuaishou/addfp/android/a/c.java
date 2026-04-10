package com.yxcorp.kuaishou.addfp.android.a;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class c {
    private static boolean d = true;
    private static int e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f2527a;
    private String b;
    private ReentrantLock c;

    private c() {
        this.b = "";
        this.c = new ReentrantLock();
    }

    private static String a(String str) {
        return TextUtils.isEmpty(str) ? "KWE_N" : str.replace("=", "").replace("&", "");
    }

    public static void a(JSONObject jSONObject) {
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if ("64".equals(next) && jSONObject.optInt(next, 1) == 0) {
                    d = false;
                }
                if ("64_level".equals(next)) {
                    e = jSONObject.optInt(next, 0);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0045 A[PHI: r4
  0x0045: PHI (r4v1 boolean) = (r4v0 boolean), (r4v2 boolean) binds: [B:12:0x0017, B:21:0x0042] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String b() {
        /*
            boolean r0 = com.yxcorp.kuaishou.addfp.android.a.c.d     // Catch: java.lang.Throwable -> L66
            if (r0 != 0) goto L7
            java.lang.String r0 = "KWE_NPN"
            return r0
        L7:
            java.lang.String r0 = ""
            int r1 = com.yxcorp.kuaishou.addfp.android.a.c.e     // Catch: java.lang.Throwable -> L66
            if (r1 != 0) goto L5f
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L66
            r2 = 33
            r3 = 1
            if (r1 >= r2) goto L46
            r2 = 29
            r4 = 0
            if (r1 < r2) goto L45
            java.lang.String r1 = android.os.Build.MODEL     // Catch: java.lang.Throwable -> L66
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L66
            if (r2 != 0) goto L3a
            java.lang.String r2 = r1.toLowerCase()     // Catch: java.lang.Throwable -> L66
            java.lang.String r5 = "redmi"
            boolean r2 = r2.contains(r5)     // Catch: java.lang.Throwable -> L66
            if (r2 == 0) goto L3a
            java.lang.String r1 = r1.toLowerCase()     // Catch: java.lang.Throwable -> L66
            java.lang.String r2 = "note 7"
            boolean r1 = r1.contains(r2)     // Catch: java.lang.Throwable -> L66
            if (r1 == 0) goto L3a
            r4 = r3
        L3a:
            java.lang.String r1 = android.os.Build.BRAND     // Catch: java.lang.Throwable -> L66
            java.lang.String r2 = "HONOR"
            boolean r1 = r1.equalsIgnoreCase(r2)     // Catch: java.lang.Throwable -> L66
            if (r1 == 0) goto L45
            goto L46
        L45:
            r3 = r4
        L46:
            if (r3 != 0) goto L5f
            com.yxcorp.kuaishou.addfp.android.Orange r1 = com.yxcorp.kuaishou.addfp.android.Orange.getInstance()     // Catch: java.lang.Throwable -> L66
            java.lang.String r1 = r1.gSer()     // Catch: java.lang.Throwable -> L66
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L66
            if (r2 != 0) goto L5f
            java.lang.String r2 = "KWE"
            boolean r2 = r1.startsWith(r2)     // Catch: java.lang.Throwable -> L66
            if (r2 != 0) goto L5f
            return r1
        L5f:
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L66
            if (r1 != 0) goto L6a
            return r0
        L66:
            r0 = move-exception
            r0.printStackTrace()
        L6a:
            java.lang.String r0 = "KWE_N"
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yxcorp.kuaishou.addfp.android.a.c.b():java.lang.String");
    }

    public static c c() {
        return b.f2526a;
    }

    public String a() {
        try {
            return !TextUtils.isEmpty(this.f2527a) ? this.f2527a : "KWE_N";
        } catch (Throwable th) {
            th.printStackTrace();
            return "KWE_N";
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(77:8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|(3:165|26|27)|30|31|32|33|34|35|36|37|38|39|40|41|42|43|169|44|(1:46)|49|50|51|52|(2:144|53)|57|58|59|60|61|62|(3:163|63|64)|66|67|(2:156|68)|(3:152|69|70)|(2:146|71)|80|81|154|82|85|86|87|88|89|90|91|92|93|94|95|(1:111)(3:101|(3:103|150|104)(1:108)|109)|112|113|167|114|(4:117|(2:119|172)(1:173)|120|115)|171|121|125) */
    /* JADX WARN: Can't wrap try/catch for region: R(82:8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|165|26|27|30|31|32|33|34|35|36|37|38|39|40|41|42|43|169|44|(1:46)|49|50|51|52|(2:144|53)|57|58|59|60|61|62|163|63|64|66|67|156|68|(3:152|69|70)|(2:146|71)|80|81|154|82|85|86|87|88|89|90|91|92|93|94|95|(1:111)(3:101|(3:103|150|104)(1:108)|109)|112|113|167|114|(4:117|(2:119|172)(1:173)|120|115)|171|121|125) */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x02f9, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x02fa, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x020d, code lost:
    
        r3 = "KWE_PE";
     */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02ad A[Catch: all -> 0x02f9, TryCatch #12 {all -> 0x02f9, blocks: (B:114:0x02a3, B:117:0x02ad, B:119:0x02c2, B:120:0x02cd, B:121:0x02d0), top: B:167:0x02a3, outer: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x036a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(android.content.Context r25, com.yxcorp.kuaishou.addfp.ResponseDfpCallback r26, boolean r27) {
        /*
            Method dump skipped, instruction units count: 886
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yxcorp.kuaishou.addfp.android.a.c.a(android.content.Context, com.yxcorp.kuaishou.addfp.ResponseDfpCallback, boolean):java.lang.String");
    }

    public void b(String str) {
        this.f2527a = str;
    }
}
