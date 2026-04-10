package com.kwad.components.ad.interstitial.b;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.utils.x;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a extends com.kwad.sdk.core.response.kwai.a {
    private static SimpleDateFormat go = new SimpleDateFormat("yyyy-MM-dd");
    public long ji = -1;
    public int jj = 0;

    public static void L(Context context) {
        String strDq = x.Dq();
        a aVar = new a();
        if (TextUtils.isEmpty(strDq)) {
            aVar.jj = 1;
            aVar.ji = System.currentTimeMillis();
            x.V(context, aVar.toJson().toString());
            return;
        }
        try {
            aVar.parseJson(new JSONObject(strDq));
            if (b(aVar.ji, System.currentTimeMillis())) {
                aVar.jj++;
            } else {
                aVar.jj = 1;
                aVar.ji = System.currentTimeMillis();
            }
            x.V(context, aVar.toJson().toString());
        } catch (Exception e2) {
            b.printStackTrace(e2);
        }
    }

    private static boolean b(long j2, long j3) {
        if (j2 > 0 && j3 > 0) {
            try {
                return go.format(new Date(j2)).equals(go.format(new Date(j3)));
            } catch (Exception e2) {
                b.printStackTrace(e2);
            }
        }
        return false;
    }

    public static int cQ() {
        String strDq = x.Dq();
        if (TextUtils.isEmpty(strDq)) {
            return 0;
        }
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(strDq));
            if (b(aVar.ji, System.currentTimeMillis())) {
                return aVar.jj;
            }
            return 0;
        } catch (Exception e2) {
            b.printStackTrace(e2);
            return 0;
        }
    }
}
