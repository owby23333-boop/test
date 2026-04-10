package com.kwad.components.ad.reward.model;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.utils.x;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class b extends com.kwad.sdk.core.response.kwai.a {
    private static SimpleDateFormat go = new SimpleDateFormat("yyyy-MM-dd");
    public long ji = -1;
    public int jj = 0;

    public static void L(Context context) {
        String strDp = x.Dp();
        b bVar = new b();
        if (TextUtils.isEmpty(strDp)) {
            bVar.jj = 1;
            bVar.ji = System.currentTimeMillis();
            x.U(context, bVar.toJson().toString());
            return;
        }
        try {
            bVar.parseJson(new JSONObject(strDp));
            if (b(bVar.ji, System.currentTimeMillis())) {
                bVar.jj++;
            } else {
                bVar.jj = 1;
                bVar.ji = System.currentTimeMillis();
            }
            x.U(context, bVar.toJson().toString());
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
    }

    private static boolean b(long j2, long j3) {
        if (j2 > 0 && j3 > 0) {
            try {
                return go.format(new Date(j2)).equals(go.format(new Date(j3)));
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.printStackTrace(e2);
            }
        }
        return false;
    }

    public static int cQ() {
        String strDp = x.Dp();
        if (TextUtils.isEmpty(strDp)) {
            return 0;
        }
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(strDp));
            if (b(bVar.ji, System.currentTimeMillis())) {
                return bVar.jj;
            }
            return 0;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
            return 0;
        }
    }
}
