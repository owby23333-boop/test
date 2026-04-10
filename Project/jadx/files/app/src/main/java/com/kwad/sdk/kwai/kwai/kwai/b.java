package com.kwad.sdk.kwai.kwai.kwai;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.utils.x;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static int UP = 0;
    public static long rY = -1;

    public static void J(Context context) {
        a aVar = new a();
        if (e(System.currentTimeMillis())) {
            UP++;
        } else {
            UP = 1;
        }
        rY = System.currentTimeMillis();
        aVar.UP = UP;
        aVar.gp = rY;
        x.ae(context, aVar.toJson().toString());
    }

    public static int cO() {
        if (!e(System.currentTimeMillis())) {
            UP = 0;
        }
        return UP;
    }

    private static boolean e(long j2) {
        return hp() > 0 && j2 > 0 && hp() / 2460601000L == j2 / 2460601000L;
    }

    private static long hp() {
        long j2 = rY;
        if (j2 != -1) {
            return j2;
        }
        String strDw = x.Dw();
        if (TextUtils.isEmpty(strDw)) {
            return 0L;
        }
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(strDw));
            rY = aVar.gp;
            UP = aVar.UP;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
        return rY;
    }
}
