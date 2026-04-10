package com.kwad.components.ad.reward.h;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.ag;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static long uN = -1;
    public static int uO;

    private static boolean j(long j) {
        return m608if() > 0 && j > 0 && m608if() / 2460601000L == j / 2460601000L;
    }

    public static void J(Context context) {
        b bVar = new b();
        if (j(System.currentTimeMillis())) {
            uO++;
        } else {
            uO = 1;
        }
        uN = System.currentTimeMillis();
        bVar.uP = uO;
        bVar.jC = uN;
        ag.ae(context, bVar.toJson().toString());
    }

    /* JADX INFO: renamed from: if, reason: not valid java name */
    private static long m608if() {
        long j = uN;
        if (j != -1) {
            return j;
        }
        String strQu = ag.Qu();
        if (TextUtils.isEmpty(strQu)) {
            return 0L;
        }
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(strQu));
            uN = bVar.jC;
            uO = bVar.uP;
        } catch (Exception e) {
            c.printStackTraceOnly(e);
        }
        return uN;
    }

    public static int dO() {
        if (!j(System.currentTimeMillis())) {
            uO = 0;
        }
        return uO;
    }
}
