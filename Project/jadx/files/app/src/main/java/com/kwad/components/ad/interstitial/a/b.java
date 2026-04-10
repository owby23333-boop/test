package com.kwad.components.ad.interstitial.a;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.utils.x;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b extends com.kwad.sdk.core.response.kwai.a {
    private static SimpleDateFormat go = new SimpleDateFormat("yyyy-MM-dd");
    public long gp = -1;
    public int jg = 0;
    public int jh = 0;

    public static void J(Context context) {
        String strDl = x.Dl();
        b bVar = new b();
        if (TextUtils.isEmpty(strDl)) {
            bVar.jg = 1;
            bVar.gp = System.currentTimeMillis();
            x.P(context, bVar.toJson().toString());
            return;
        }
        try {
            bVar.parseJson(new JSONObject(strDl));
            if (b(bVar.gp, System.currentTimeMillis())) {
                bVar.jg++;
            } else {
                bVar.jg = 1;
                bVar.jh = 0;
                bVar.gp = System.currentTimeMillis();
            }
            x.P(context, bVar.toJson().toString());
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
    }

    public static void K(Context context) {
        String strDl = x.Dl();
        b bVar = new b();
        if (TextUtils.isEmpty(strDl)) {
            bVar.jh = 1;
            bVar.gp = System.currentTimeMillis();
            x.P(context, bVar.toJson().toString());
            return;
        }
        try {
            bVar.parseJson(new JSONObject(strDl));
            if (b(bVar.gp, System.currentTimeMillis())) {
                bVar.jh++;
            } else {
                bVar.jh = 1;
                bVar.jg = 0;
                bVar.gp = System.currentTimeMillis();
            }
            x.P(context, bVar.toJson().toString());
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
    }

    private static boolean b(long j2, long j3) {
        if (j2 > 0 && j3 > 0) {
            try {
                return go.format(new Date(j2)).equals(go.format(new Date(j3)));
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            }
        }
        return false;
    }

    public static int cO() {
        String strDl = x.Dl();
        if (TextUtils.isEmpty(strDl)) {
            return 0;
        }
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(strDl));
            return bVar.jg;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            return 0;
        }
    }

    public static int cP() {
        String strDl = x.Dl();
        if (TextUtils.isEmpty(strDl)) {
            return 0;
        }
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(strDl));
            return bVar.jh;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            return 0;
        }
    }
}
