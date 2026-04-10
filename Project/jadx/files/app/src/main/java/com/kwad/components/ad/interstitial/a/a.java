package com.kwad.components.ad.interstitial.a;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.utils.x;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a extends com.kwad.sdk.core.response.kwai.a {
    private static SimpleDateFormat go = new SimpleDateFormat("yyyy-MM-dd");
    public long gp = -1;
    public int jf = 0;

    public static void J(Context context) {
        String strDm = x.Dm();
        a aVar = new a();
        if (TextUtils.isEmpty(strDm)) {
            aVar.jf = 1;
            aVar.gp = System.currentTimeMillis();
            x.Q(context, aVar.toJson().toString());
            return;
        }
        try {
            aVar.parseJson(new JSONObject(strDm));
            if (b(aVar.gp, System.currentTimeMillis())) {
                aVar.jf++;
            } else {
                aVar.jf = 1;
                aVar.gp = System.currentTimeMillis();
            }
            x.Q(context, aVar.toJson().toString());
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
        String strDm = x.Dm();
        if (TextUtils.isEmpty(strDm)) {
            return 0;
        }
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(strDm));
            if (b(aVar.gp, System.currentTimeMillis())) {
                return aVar.jf;
            }
            return 0;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            return 0;
        }
    }
}
