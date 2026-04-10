package com.kwad.components.ad.reward.e;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.utils.x;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static long rY = -1;
    public static int rZ;

    public static void J(Context context) {
        b bVar = new b();
        if (e(System.currentTimeMillis())) {
            rZ++;
        } else {
            rZ = 1;
        }
        rY = System.currentTimeMillis();
        bVar.sa = rZ;
        bVar.gp = rY;
        x.S(context, bVar.toJson().toString());
    }

    public static int cO() {
        if (!e(System.currentTimeMillis())) {
            rZ = 0;
        }
        return rZ;
    }

    private static boolean e(long j2) {
        return hp() > 0 && j2 > 0 && hp() / 2460601000L == j2 / 2460601000L;
    }

    private static long hp() {
        long j2 = rY;
        if (j2 != -1) {
            return j2;
        }
        String strDn = x.Dn();
        if (TextUtils.isEmpty(strDn)) {
            return 0L;
        }
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(strDn));
            rY = bVar.gp;
            rZ = bVar.sa;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
        return rY;
    }
}
