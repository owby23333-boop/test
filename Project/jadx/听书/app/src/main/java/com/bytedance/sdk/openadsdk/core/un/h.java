package com.bytedance.sdk.openadsdk.core.un;

import android.os.Looper;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class h {
    public static void z(final com.bytedance.sdk.openadsdk.core.iq.na naVar, final Double d) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            com.bytedance.sdk.component.uy.e.g(new com.bytedance.sdk.component.uy.fo("win") { // from class: com.bytedance.sdk.openadsdk.core.un.h.1
                @Override // java.lang.Runnable
                public void run() {
                    h.dl(naVar, d);
                }
            });
        } else {
            dl(naVar, d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dl(com.bytedance.sdk.openadsdk.core.iq.na naVar, Double d) {
        if (naVar == null || naVar.fq() == null) {
            return;
        }
        naVar.ac().dl(1);
        try {
            Object obj = naVar.fq().get("sdk_bidding_type");
            if (obj != null && Integer.parseInt(obj.toString()) == 2) {
                String strReplace = (String) naVar.fq().get("nurl");
                if (TextUtils.isEmpty(strReplace)) {
                    return;
                }
                if (d != null) {
                    strReplace = strReplace.replace("${AUCTION_BID_TO_WIN}", String.valueOf(d));
                }
                com.bytedance.sdk.openadsdk.core.zw.z().z(z(naVar, strReplace, "${AUCTION_EXT}"));
            }
        } catch (Throwable unused) {
        }
    }

    public static void z(final com.bytedance.sdk.openadsdk.core.iq.na naVar, final Double d, final String str, final String str2) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            com.bytedance.sdk.component.uy.e.g(new com.bytedance.sdk.component.uy.fo("loss") { // from class: com.bytedance.sdk.openadsdk.core.un.h.2
                @Override // java.lang.Runnable
                public void run() {
                    h.dl(naVar, d, str, str2);
                }
            });
        } else {
            dl(naVar, d, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dl(com.bytedance.sdk.openadsdk.core.iq.na naVar, Double d, String str, String str2) {
        if (naVar == null || naVar.fq() == null) {
            return;
        }
        try {
            naVar.ac().dl(2);
            Object obj = naVar.fq().get("sdk_bidding_type");
            if (obj != null && Integer.parseInt(obj.toString()) == 2) {
                String strReplace = (String) naVar.fq().get("lurl");
                if (TextUtils.isEmpty(strReplace)) {
                    return;
                }
                if (d != null) {
                    strReplace = strReplace.replace("${AUCTION_PRICE}", String.valueOf(d));
                }
                if (str != null) {
                    strReplace = strReplace.replace("${AUCTION_LOSS}", str);
                }
                if (str2 != null) {
                    strReplace = strReplace.replace("${AUCTION_WINNER}", str2);
                }
                com.bytedance.sdk.openadsdk.core.zw.z().z(z(naVar, strReplace, "${AUCTION_EXT}"));
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0039 A[PHI: r0
  0x0039: PHI (r0v3 java.lang.String) = (r0v2 java.lang.String), (r0v5 java.lang.String) binds: [B:8:0x001c, B:13:0x002e] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String z(com.bytedance.sdk.openadsdk.core.iq.na r3, java.lang.String r4, java.lang.String r5) throws java.lang.Exception {
        /*
            if (r3 == 0) goto L82
            if (r4 == 0) goto L82
            boolean r0 = r4.contains(r5)
            if (r0 != 0) goto Lc
            goto L82
        Lc:
            java.lang.String r3 = r3.vk()
            com.bytedance.sdk.openadsdk.core.dl.m r0 = com.bytedance.sdk.openadsdk.core.dl.m.z()
            r1 = 0
            android.util.Pair r3 = r0.z(r3, r1)
            java.lang.String r0 = ""
            r1 = 3
            if (r3 == 0) goto L39
            java.lang.Object r2 = r3.second
            if (r2 == 0) goto L2c
            java.lang.Object r0 = r3.second
            org.json.JSONObject r0 = (org.json.JSONObject) r0
            java.lang.String r2 = "message"
            java.lang.String r0 = r0.optString(r2)
        L2c:
            java.lang.Object r2 = r3.first
            if (r2 == 0) goto L39
            java.lang.Object r3 = r3.first
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            goto L3a
        L39:
            r3 = r1
        L3a:
            if (r3 == r1) goto L77
            java.net.URL r3 = new java.net.URL     // Catch: java.lang.Exception -> L73
            r3.<init>(r4)     // Catch: java.lang.Exception -> L73
            java.lang.String r3 = r3.getQuery()     // Catch: java.lang.Exception -> L73
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Exception -> L73
            if (r3 == 0) goto L5f
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L73
            r3.<init>()     // Catch: java.lang.Exception -> L73
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Exception -> L73
            java.lang.String r1 = "?abort_aes=1"
            java.lang.StringBuilder r3 = r3.append(r1)     // Catch: java.lang.Exception -> L73
            java.lang.String r4 = r3.toString()     // Catch: java.lang.Exception -> L73
            goto L77
        L5f:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L73
            r3.<init>()     // Catch: java.lang.Exception -> L73
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Exception -> L73
            java.lang.String r1 = "&abort_aes=1"
            java.lang.StringBuilder r3 = r3.append(r1)     // Catch: java.lang.Exception -> L73
            java.lang.String r4 = r3.toString()     // Catch: java.lang.Exception -> L73
            goto L77
        L73:
            r3 = move-exception
            com.bytedance.sdk.component.utils.wp.z(r3)
        L77:
            java.lang.String r3 = "UTF-8"
            java.lang.String r3 = java.net.URLEncoder.encode(r0, r3)
            java.lang.String r3 = r4.replace(r5, r3)
            return r3
        L82:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.un.h.z(com.bytedance.sdk.openadsdk.core.iq.na, java.lang.String, java.lang.String):java.lang.String");
    }
}
