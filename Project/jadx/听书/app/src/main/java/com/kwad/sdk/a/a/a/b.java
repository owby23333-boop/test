package com.kwad.sdk.a.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.ag;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class b {
    public static int agV = 0;
    public static long uN = -1;

    private static boolean j(long j) {
        return m611if() > 0 && j > 0 && m611if() / 2460601000L == j / 2460601000L;
    }

    public static void J(Context context) {
        a aVar = new a();
        if (j(System.currentTimeMillis())) {
            agV++;
        } else {
            agV = 1;
        }
        uN = System.currentTimeMillis();
        aVar.agV = agV;
        aVar.jC = uN;
        ag.an(context, aVar.toJson().toString());
    }

    /* JADX INFO: renamed from: if, reason: not valid java name */
    private static long m611if() {
        long j = uN;
        if (j != -1) {
            return j;
        }
        String strQG = ag.QG();
        if (TextUtils.isEmpty(strQG)) {
            return 0L;
        }
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(strQG));
            uN = aVar.jC;
            agV = aVar.agV;
        } catch (Exception e) {
            c.printStackTraceOnly(e);
        }
        return uN;
    }

    public static int dO() {
        if (!j(System.currentTimeMillis())) {
            agV = 0;
        }
        return agV;
    }
}
