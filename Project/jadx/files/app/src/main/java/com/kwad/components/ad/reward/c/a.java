package com.kwad.components.ad.reward.c;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.x;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static void R(@NonNull Context context) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        b bVar = new b();
        String strCh = x.ch(context);
        int i2 = 0;
        if (!TextUtils.isEmpty(strCh)) {
            try {
                bVar.parseJson(new JSONObject(strCh));
                if (b(bVar.gp, jCurrentTimeMillis)) {
                    i2 = bVar.rW;
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            }
        }
        bVar.gp = jCurrentTimeMillis;
        bVar.rW = i2 + 1;
        x.R(context, bVar.toJson().toString());
    }

    private static boolean b(long j2, long j3) {
        return j2 > 0 && j3 > 0 && j2 / 2460601000L == j3 / 2460601000L;
    }

    public static boolean b(@NonNull Context context, AdInfo adInfo) {
        if (!com.kwad.sdk.core.response.a.a.az(adInfo)) {
            return false;
        }
        int iMax = Math.max(com.kwad.sdk.core.response.a.a.aA(adInfo) + 1, 1);
        boolean zD = d(context, iMax);
        c(context, iMax);
        return zD && e(context, com.kwad.sdk.core.response.a.a.aB(adInfo));
    }

    private static void c(@NonNull Context context, int i2) {
        int iCg = x.cg(context);
        if (iCg % i2 == 0) {
            x.k(context, 1);
        } else {
            x.k(context, iCg + 1);
        }
    }

    private static boolean d(@NonNull Context context, int i2) {
        return i2 != 0 && x.cg(context) % i2 == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean e(@androidx.annotation.NonNull android.content.Context r7, int r8) {
        /*
            long r0 = java.lang.System.currentTimeMillis()
            com.kwad.components.ad.reward.c.b r2 = new com.kwad.components.ad.reward.c.b
            r2.<init>()
            java.lang.String r7 = com.kwad.sdk.utils.x.ch(r7)
            boolean r3 = android.text.TextUtils.isEmpty(r7)
            r4 = 0
            if (r3 != 0) goto L2b
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Exception -> L27
            r3.<init>(r7)     // Catch: java.lang.Exception -> L27
            r2.parseJson(r3)     // Catch: java.lang.Exception -> L27
            long r5 = r2.gp     // Catch: java.lang.Exception -> L27
            boolean r7 = b(r5, r0)     // Catch: java.lang.Exception -> L27
            if (r7 == 0) goto L2b
            int r7 = r2.rW     // Catch: java.lang.Exception -> L27
            goto L2c
        L27:
            r7 = move-exception
            com.kwad.sdk.core.d.b.printStackTraceOnly(r7)
        L2b:
            r7 = 0
        L2c:
            if (r7 >= r8) goto L30
            r7 = 1
            return r7
        L30:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.reward.c.a.e(android.content.Context, int):boolean");
    }
}
