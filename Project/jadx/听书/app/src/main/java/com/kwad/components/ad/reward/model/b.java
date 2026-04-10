package com.kwad.components.ad.reward.model;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.utils.ag;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class b extends com.kwad.sdk.core.response.a.a {
    private static SimpleDateFormat jB = new SimpleDateFormat("yyyy-MM-dd");
    public long lY = -1;
    public int lZ = 0;

    public static void L(Context context) {
        String strQw = ag.Qw();
        b bVar = new b();
        if (TextUtils.isEmpty(strQw)) {
            bVar.lZ = 1;
            bVar.lY = System.currentTimeMillis();
            ag.ag(context, bVar.toJson().toString());
            return;
        }
        try {
            bVar.parseJson(new JSONObject(strQw));
            if (b(bVar.lY, System.currentTimeMillis())) {
                bVar.lZ++;
            } else {
                bVar.lZ = 1;
                bVar.lY = System.currentTimeMillis();
            }
            ag.ag(context, bVar.toJson().toString());
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    public static int dQ() {
        String strQw = ag.Qw();
        if (TextUtils.isEmpty(strQw)) {
            return 0;
        }
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(strQw));
            if (b(bVar.lY, System.currentTimeMillis())) {
                return bVar.lZ;
            }
            return 0;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            return 0;
        }
    }

    private static boolean b(long j, long j2) {
        if (j > 0 && j2 > 0) {
            try {
                return jB.format(new Date(j)).equals(jB.format(new Date(j2)));
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }
        return false;
    }
}
