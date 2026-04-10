package com.yxcorp.kuaishou.addfp.android.a;

import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f20605d = true;
    private String a;
    private String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ReentrantLock f20606c;

    private c() {
        this.b = "";
        this.f20606c = new ReentrantLock();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r7) {
        /*
            boolean r0 = com.yxcorp.kuaishou.addfp.android.a.c.f20605d     // Catch: java.lang.Throwable -> La7
            if (r0 != 0) goto L7
            java.lang.String r7 = "KWE_NPN"
            return r7
        L7:
            r0 = 1
            r1 = 0
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L11
            r3 = 26
            if (r2 < r3) goto L15
            r2 = 1
            goto L16
        L11:
            r2 = move-exception
            r2.printStackTrace()     // Catch: java.lang.Throwable -> La7
        L15:
            r2 = 0
        L16:
            if (r2 != 0) goto L23
            java.lang.String r2 = b()     // Catch: java.lang.Throwable -> La7
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> La7
            if (r3 != 0) goto L23
            return r2
        L23:
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> La7
            r3 = 29
            if (r2 < r3) goto L4b
            java.lang.String r2 = android.os.Build.MODEL     // Catch: java.lang.Throwable -> La7
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> La7
            if (r3 != 0) goto L4b
            java.lang.String r3 = r2.toLowerCase()     // Catch: java.lang.Throwable -> La7
            java.lang.String r4 = "redmi"
            boolean r3 = r3.contains(r4)     // Catch: java.lang.Throwable -> La7
            if (r3 == 0) goto L4b
            java.lang.String r2 = r2.toLowerCase()     // Catch: java.lang.Throwable -> La7
            java.lang.String r3 = "note 7"
            boolean r2 = r2.contains(r3)     // Catch: java.lang.Throwable -> La7
            if (r2 == 0) goto L4b
            r2 = 1
            goto L4c
        L4b:
            r2 = 0
        L4c:
            if (r2 != 0) goto L65
            com.yxcorp.kuaishou.addfp.android.Orange r2 = com.yxcorp.kuaishou.addfp.android.Orange.getInstance()     // Catch: java.lang.Throwable -> La7
            java.lang.String r2 = r2.gSer()     // Catch: java.lang.Throwable -> La7
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> La7
            if (r3 != 0) goto L65
            java.lang.String r3 = "KWE"
            boolean r3 = r2.startsWith(r3)     // Catch: java.lang.Throwable -> La7
            if (r3 != 0) goto L65
            return r2
        L65:
            java.lang.String r2 = "android.permission.READ_PHONE_STATE"
            java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch: java.lang.Throwable -> La7
            r3 = 0
        L6c:
            if (r3 > 0) goto L83
            r4 = r2[r1]     // Catch: java.lang.Throwable -> L82
            int r5 = android.os.Process.myPid()     // Catch: java.lang.Throwable -> L82
            int r6 = android.os.Process.myUid()     // Catch: java.lang.Throwable -> L82
            int r4 = r7.checkPermission(r4, r5, r6)     // Catch: java.lang.Throwable -> L82
            r5 = -1
            if (r4 == r5) goto L82
            int r3 = r3 + 1
            goto L6c
        L82:
            r0 = 0
        L83:
            java.lang.String r7 = "unknown"
            if (r0 == 0) goto L98
            java.lang.String r0 = android.os.Build.getSerial()     // Catch: java.lang.Throwable -> La7
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> La7
            if (r1 != 0) goto L98
            boolean r1 = r0.equals(r7)     // Catch: java.lang.Throwable -> La7
            if (r1 != 0) goto L98
            return r0
        L98:
            java.lang.String r0 = android.os.Build.SERIAL     // Catch: java.lang.Throwable -> La7
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> La7
            if (r1 != 0) goto Lab
            boolean r7 = r0.equals(r7)     // Catch: java.lang.Throwable -> La7
            if (r7 != 0) goto Lab
            return r0
        La7:
            r7 = move-exception
            r7.printStackTrace()
        Lab:
            java.lang.String r7 = "KWE_N"
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yxcorp.kuaishou.addfp.android.a.c.a(android.content.Context):java.lang.String");
    }

    private static String a(String str) {
        return TextUtils.isEmpty(str) ? "KWE_N" : str.replace("=", "").replace(DispatchConstants.SIGN_SPLIT_SYMBOL, "");
    }

    public static void a(JSONObject jSONObject) {
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if ("64".equals(next) && jSONObject.optInt(next, 1) == 0) {
                    f20605d = false;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x003c A[EXC_TOP_SPLITTER, PHI: r2
  0x003c: PHI (r2v2 java.io.BufferedReader) = (r2v1 java.io.BufferedReader), (r2v6 java.io.BufferedReader) binds: [B:22:0x003a, B:17:0x0032] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String b() {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L35
            java.lang.String r2 = "/sys/class/android_usb/android0/iSerial"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L35
            boolean r2 = r1.exists()     // Catch: java.lang.Throwable -> L35
            if (r2 == 0) goto L31
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L35
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L35
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L35
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L35
            java.lang.String r1 = r2.readLine()     // Catch: java.lang.Throwable -> L2f
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L2f
            if (r3 != 0) goto L32
            java.lang.String r0 = r1.trim()     // Catch: java.lang.Throwable -> L2f
            r2.close()     // Catch: java.lang.Throwable -> L2a
            goto L2e
        L2a:
            r1 = move-exception
            r1.printStackTrace()
        L2e:
            return r0
        L2f:
            r1 = move-exception
            goto L37
        L31:
            r2 = r0
        L32:
            if (r2 == 0) goto L44
            goto L3c
        L35:
            r1 = move-exception
            r2 = r0
        L37:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L45
            if (r2 == 0) goto L44
        L3c:
            r2.close()     // Catch: java.lang.Throwable -> L40
            goto L44
        L40:
            r1 = move-exception
            r1.printStackTrace()
        L44:
            return r0
        L45:
            r0 = move-exception
            if (r2 == 0) goto L50
            r2.close()     // Catch: java.lang.Throwable -> L4c
            goto L50
        L4c:
            r1 = move-exception
            r1.printStackTrace()
        L50:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yxcorp.kuaishou.addfp.android.a.c.b():java.lang.String");
    }

    public static c c() {
        return b.a;
    }

    public String a() {
        try {
            return !TextUtils.isEmpty(this.a) ? this.a : "KWE_N";
        } catch (Throwable th) {
            th.printStackTrace();
            return "KWE_N";
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(76:8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|161|26|27|30|31|32|33|34|35|36|37|38|39|40|41|42|43|163|44|(1:46)|49|50|51|52|171|53|57|58|59|60|61|62|(6:155|63|64|157|65|66)|173|69|70|(2:151|71)|(3:148|72|73)|159|74|83|84|85|86|87|88|89|90|91|(1:108)(3:97|(4:99|100|167|101)(1:105)|106)|109|110|(5:146|111|(4:114|(2:116|175)(1:176)|117|112)|174|118)|122|134|(1:136)|137|138) */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x029b A[Catch: all -> 0x02e1, TryCatch #0 {all -> 0x02e1, blocks: (B:111:0x0292, B:114:0x029b, B:116:0x02af, B:117:0x02ba, B:118:0x02bd), top: B:146:0x0292, outer: #14 }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x035f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(android.content.Context r23, com.yxcorp.kuaishou.addfp.ResponseDfpCallback r24, boolean r25) {
        /*
            Method dump skipped, instruction units count: 878
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yxcorp.kuaishou.addfp.android.a.c.a(android.content.Context, com.yxcorp.kuaishou.addfp.ResponseDfpCallback, boolean):java.lang.String");
    }

    public void b(String str) {
        this.a = str;
    }
}
