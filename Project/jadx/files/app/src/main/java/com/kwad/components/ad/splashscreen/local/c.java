package com.kwad.components.ad.splashscreen.local;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.utils.x;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class c extends com.kwad.sdk.core.response.kwai.a {
    private static SimpleDateFormat go = new SimpleDateFormat("yyyy-MM-dd");
    public long gp = 0;
    public int gq = 0;

    public static void Z(Context context) {
        String strDo = x.Do();
        c cVar = new c();
        if (TextUtils.isEmpty(strDo)) {
            cVar.gq = 1;
            cVar.gp = System.currentTimeMillis();
            x.T(context, cVar.toJson().toString());
            return;
        }
        try {
            cVar.parseJson(new JSONObject(strDo));
            if (b(cVar.gp, System.currentTimeMillis())) {
                cVar.gq++;
            } else {
                cVar.gq = 1;
            }
            cVar.gp = System.currentTimeMillis();
            x.T(context, cVar.toJson().toString());
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
}
