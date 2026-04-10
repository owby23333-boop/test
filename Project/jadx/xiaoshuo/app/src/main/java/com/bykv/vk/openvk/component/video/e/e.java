package com.bykv.vk.openvk.component.video.e;

import android.content.Context;
import com.bykv.vk.openvk.component.video.api.e.bf;
import com.bykv.vk.openvk.component.video.api.vn.d;
import com.yuewen.so2;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public static int bf = 10;
    public static int d = 10;
    public static int e = 10;
    private static bf ga = null;
    public static int tg = 10;

    public static int bf() {
        return e;
    }

    public static int d() {
        return bf;
    }

    public static void e(Context context) {
        com.bykv.vk.openvk.component.video.api.vn.e.e(context);
    }

    public static int ga() {
        return tg;
    }

    public static int tg() {
        return d;
    }

    public static void e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            e = jSONObject.optInt("splash", 10);
            bf = jSONObject.optInt(so2.ab, 10);
            d = jSONObject.optInt("brand", 10);
            int iOptInt = jSONObject.optInt("other", 10);
            tg = iOptInt;
            if (e < 0) {
                e = 10;
            }
            if (bf < 0) {
                bf = 10;
            }
            if (d < 0) {
                d = 10;
            }
            if (iOptInt < 0) {
                tg = 10;
            }
            d.bf("MediaConfig", "splash=", Integer.valueOf(e), ",reward=", Integer.valueOf(bf), ",brand=", Integer.valueOf(d), ",other=", Integer.valueOf(tg));
        } catch (Throwable th) {
            d.tg("MediaConfig", th.getMessage());
        }
    }

    public static void e(bf bfVar) {
        ga = bfVar;
    }

    public static void e() {
        bf bfVar = ga;
        if (bfVar != null) {
            bfVar.ga();
        }
    }
}
