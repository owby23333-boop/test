package com.kwad.components.ad.reward.d;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ag;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static boolean b(long j, long j2) {
        return j > 0 && j2 > 0 && j / 2460601000L == j2 / 2460601000L;
    }

    private static void c(Context context, int i) {
        int iCX = ag.cX(context);
        if (iCX % i == 0) {
            ag.m(context, 1);
        } else {
            ag.m(context, iCX + 1);
        }
    }

    private static boolean d(Context context, int i) {
        return i != 0 && ag.cX(context) % i == 0;
    }

    public static void S(Context context) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        b bVar = new b();
        String strCY = ag.cY(context);
        int i = 0;
        if (!TextUtils.isEmpty(strCY)) {
            try {
                bVar.parseJson(new JSONObject(strCY));
                if (b(bVar.jC, jCurrentTimeMillis)) {
                    i = bVar.ur;
                }
            } catch (Exception e) {
                c.printStackTraceOnly(e);
            }
        }
        bVar.jC = jCurrentTimeMillis;
        bVar.ur = i + 1;
        ag.ad(context, bVar.toJson().toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean e(android.content.Context r7, int r8) {
        /*
            long r0 = java.lang.System.currentTimeMillis()
            com.kwad.components.ad.reward.d.b r2 = new com.kwad.components.ad.reward.d.b
            r2.<init>()
            java.lang.String r7 = com.kwad.sdk.utils.ag.cY(r7)
            boolean r3 = android.text.TextUtils.isEmpty(r7)
            r4 = 0
            if (r3 != 0) goto L2b
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Exception -> L27
            r3.<init>(r7)     // Catch: java.lang.Exception -> L27
            r2.parseJson(r3)     // Catch: java.lang.Exception -> L27
            long r5 = r2.jC     // Catch: java.lang.Exception -> L27
            boolean r7 = b(r5, r0)     // Catch: java.lang.Exception -> L27
            if (r7 == 0) goto L2b
            int r7 = r2.ur     // Catch: java.lang.Exception -> L27
            goto L2c
        L27:
            r7 = move-exception
            com.kwad.sdk.core.d.c.printStackTraceOnly(r7)
        L2b:
            r7 = r4
        L2c:
            if (r7 >= r8) goto L30
            r7 = 1
            return r7
        L30:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.reward.d.a.e(android.content.Context, int):boolean");
    }

    public static boolean b(Context context, AdInfo adInfo) {
        if (!com.kwad.sdk.core.response.b.a.aG(adInfo)) {
            return false;
        }
        int iMax = Math.max(com.kwad.sdk.core.response.b.a.aH(adInfo) + 1, 1);
        boolean zD = d(context, iMax);
        c(context, iMax);
        return zD && e(context, com.kwad.sdk.core.response.b.a.aI(adInfo));
    }
}
