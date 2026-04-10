package com.kwad.components.ad.interstitial.c;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.ag;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class b extends com.kwad.sdk.core.response.a.a {
    private static SimpleDateFormat jB = new SimpleDateFormat("yyyy-MM-dd");
    public long jC = -1;
    public int lW = 0;
    public int lX = 0;

    private static boolean b(long j, long j2) {
        if (j > 0 && j2 > 0) {
            try {
                return jB.format(new Date(j)).equals(jB.format(new Date(j2)));
            } catch (Exception e) {
                c.printStackTraceOnly(e);
            }
        }
        return false;
    }

    public static void J(Context context) {
        String strQt = ag.Qt();
        b bVar = new b();
        if (TextUtils.isEmpty(strQt)) {
            bVar.lW = 1;
            bVar.jC = System.currentTimeMillis();
            ag.ac(context, bVar.toJson().toString());
            return;
        }
        try {
            bVar.parseJson(new JSONObject(strQt));
            if (b(bVar.jC, System.currentTimeMillis())) {
                bVar.lW++;
            } else {
                bVar.lW = 1;
                bVar.lX = 0;
                bVar.jC = System.currentTimeMillis();
            }
            ag.ac(context, bVar.toJson().toString());
        } catch (Exception e) {
            c.printStackTraceOnly(e);
        }
    }

    public static void K(Context context) {
        String strQt = ag.Qt();
        b bVar = new b();
        if (TextUtils.isEmpty(strQt)) {
            bVar.lX = 1;
            bVar.jC = System.currentTimeMillis();
            ag.ac(context, bVar.toJson().toString());
            return;
        }
        try {
            bVar.parseJson(new JSONObject(strQt));
            if (b(bVar.jC, System.currentTimeMillis())) {
                bVar.lX++;
            } else {
                bVar.lX = 1;
                bVar.lW = 0;
                bVar.jC = System.currentTimeMillis();
            }
            ag.ac(context, bVar.toJson().toString());
        } catch (Exception e) {
            c.printStackTraceOnly(e);
        }
    }

    public static int dO() {
        String strQt = ag.Qt();
        if (TextUtils.isEmpty(strQt)) {
            return 0;
        }
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(strQt));
            return bVar.lW;
        } catch (Exception e) {
            c.printStackTraceOnly(e);
            return 0;
        }
    }

    public static int dP() {
        String strQt = ag.Qt();
        if (TextUtils.isEmpty(strQt)) {
            return 0;
        }
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(strQt));
            return bVar.lX;
        } catch (Exception e) {
            c.printStackTraceOnly(e);
            return 0;
        }
    }
}
