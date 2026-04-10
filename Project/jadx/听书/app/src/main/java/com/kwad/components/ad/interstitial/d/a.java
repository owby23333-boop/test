package com.kwad.components.ad.interstitial.d;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.ag;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class a extends com.kwad.sdk.core.response.a.a {
    private static SimpleDateFormat jB = new SimpleDateFormat("yyyy-MM-dd");
    public long lY = -1;
    public int lZ = 0;

    public static void L(Context context) {
        String strQx = ag.Qx();
        a aVar = new a();
        if (TextUtils.isEmpty(strQx)) {
            aVar.lZ = 1;
            aVar.lY = System.currentTimeMillis();
            ag.ah(context, aVar.toJson().toString());
            return;
        }
        try {
            aVar.parseJson(new JSONObject(strQx));
            if (b(aVar.lY, System.currentTimeMillis())) {
                aVar.lZ++;
            } else {
                aVar.lZ = 1;
                aVar.lY = System.currentTimeMillis();
            }
            ag.ah(context, aVar.toJson().toString());
        } catch (Exception e) {
            c.printStackTrace(e);
        }
    }

    public static int dQ() {
        String strQx = ag.Qx();
        if (TextUtils.isEmpty(strQx)) {
            return 0;
        }
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(strQx));
            if (b(aVar.lY, System.currentTimeMillis())) {
                return aVar.lZ;
            }
            return 0;
        } catch (Exception e) {
            c.printStackTrace(e);
            return 0;
        }
    }

    private static boolean b(long j, long j2) {
        if (j > 0 && j2 > 0) {
            try {
                return jB.format(new Date(j)).equals(jB.format(new Date(j2)));
            } catch (Exception e) {
                c.printStackTrace(e);
            }
        }
        return false;
    }
}
