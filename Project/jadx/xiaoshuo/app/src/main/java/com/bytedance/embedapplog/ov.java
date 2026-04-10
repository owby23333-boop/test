package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

/* JADX INFO: loaded from: classes.dex */
public class ov {
    private static volatile String e;

    public static String e(Context context, wl wlVar) {
        AdvertisingIdClient.Info advertisingIdInfo;
        if (TextUtils.isEmpty(e)) {
            synchronized (ov.class) {
                if (!TextUtils.isEmpty(e)) {
                    return e;
                }
                try {
                    advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
                } catch (Throwable th) {
                    if (!(th instanceof ClassNotFoundException) && !(th instanceof NoClassDefFoundError)) {
                        th.printStackTrace();
                    }
                }
                String id = advertisingIdInfo != null ? advertisingIdInfo.getId() : null;
                if (TextUtils.isEmpty(id)) {
                    id = wlVar.tg().getString("google_aid", null);
                } else if (!TextUtils.equals(wlVar.tg().getString("google_aid", null), id)) {
                    e(context, id, wlVar);
                }
                e = id;
            }
        }
        return e;
    }

    private static void e(Context context, String str, wl wlVar) {
        if (TextUtils.isEmpty(str) || context == null) {
            return;
        }
        wlVar.tg().edit().putString("google_aid", str).apply();
    }
}
