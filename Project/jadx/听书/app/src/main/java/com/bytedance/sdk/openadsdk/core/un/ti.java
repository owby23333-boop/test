package com.bytedance.sdk.openadsdk.core.un;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ti {
    private static String z;

    /* JADX WARN: Removed duplicated region for block: B:48:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String z(java.lang.String r6) {
        /*
            java.lang.String r0 = "data/data/com.union_test.toutiao/"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r2 = 0
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4d
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4d
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4d
            java.lang.StringBuilder r6 = r4.append(r6)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4d
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4d
            r3.<init>(r6)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4d
            boolean r6 = r3.exists()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4d
            if (r6 != 0) goto L21
            return r2
        L21:
            java.io.FileReader r6 = new java.io.FileReader     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4d
            r6.<init>(r3)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4d
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L45
            r0.<init>(r6)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L45
        L2b:
            java.lang.String r2 = r0.readLine()     // Catch: java.lang.Exception -> L40 java.lang.Throwable -> L63
            if (r2 == 0) goto L35
            r1.append(r2)     // Catch: java.lang.Exception -> L40 java.lang.Throwable -> L63
            goto L2b
        L35:
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L40 java.lang.Throwable -> L63
            r6.close()     // Catch: java.lang.Throwable -> L3c
        L3c:
            r0.close()     // Catch: java.lang.Throwable -> L3f
        L3f:
            return r1
        L40:
            r2 = move-exception
            goto L51
        L42:
            r1 = move-exception
            r0 = r2
            goto L64
        L45:
            r0 = move-exception
            r5 = r2
            r2 = r0
            r0 = r5
            goto L51
        L4a:
            r1 = move-exception
            r0 = r2
            goto L65
        L4d:
            r6 = move-exception
            r0 = r2
            r2 = r6
            r6 = r0
        L51:
            com.bytedance.sdk.component.utils.wp.z(r2)     // Catch: java.lang.Throwable -> L63
            if (r6 == 0) goto L59
            r6.close()     // Catch: java.lang.Throwable -> L59
        L59:
            if (r0 == 0) goto L5e
            r0.close()     // Catch: java.lang.Throwable -> L5e
        L5e:
            java.lang.String r6 = r1.toString()
            return r6
        L63:
            r1 = move-exception
        L64:
            r2 = r6
        L65:
            if (r2 == 0) goto L6a
            r2.close()     // Catch: java.lang.Throwable -> L6a
        L6a:
            if (r0 == 0) goto L6f
            r0.close()     // Catch: java.lang.Throwable -> L6f
        L6f:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.un.ti.z(java.lang.String):java.lang.String");
    }

    public static boolean z() {
        if (com.bytedance.sdk.component.utils.wp.dl()) {
            return com.bytedance.sdk.openadsdk.core.uy.ls().t();
        }
        return false;
    }

    public static String z(String str, String str2) {
        return str.contains("https://api-access.pangolin-sdk-toutiao.com") ? str.replace("https://api-access.pangolin-sdk-toutiao.com", str2) : str;
    }

    public static String g(String str) {
        try {
            if (!z()) {
                return str;
            }
            String strY = com.bytedance.sdk.openadsdk.core.uy.ls().y();
            return TextUtils.isEmpty(strY) ? str : Uri.parse(str).buildUpon().appendQueryParameter(g(), strY).appendQueryParameter("aid", "5001121").toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    public static void z(Map<String, String> map) {
        if (z()) {
            map.put("x-app-id", "5001121");
            String strY = com.bytedance.sdk.openadsdk.core.uy.ls().y();
            if (TextUtils.isEmpty(strY)) {
                return;
            }
            map.put("x-device-id", strY);
        }
    }

    public static String g() {
        if (TextUtils.isEmpty(z)) {
            z = new String(Base64.decode("ZGV2aWNlX2lk", 0));
        }
        return z;
    }
}
