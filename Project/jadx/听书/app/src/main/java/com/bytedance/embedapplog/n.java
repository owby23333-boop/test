package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

/* JADX INFO: loaded from: classes2.dex */
public class n {
    private static volatile String z;

    public static String z(Context context, bv bvVar) {
        AdvertisingIdClient.Info advertisingIdInfo;
        if (TextUtils.isEmpty(z)) {
            synchronized (n.class) {
                if (!TextUtils.isEmpty(z)) {
                    return z;
                }
                try {
                    advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
                } catch (Throwable th) {
                    if (!(th instanceof ClassNotFoundException) && !(th instanceof NoClassDefFoundError)) {
                        com.bytedance.sdk.component.utils.wp.z(th);
                    }
                }
                String id = advertisingIdInfo != null ? advertisingIdInfo.getId() : null;
                if (TextUtils.isEmpty(id)) {
                    id = bvVar.gc().getString("google_aid", null);
                } else if (!TextUtils.equals(bvVar.gc().getString("google_aid", null), id)) {
                    z(context, id, bvVar);
                }
                z = id;
            }
        }
        return z;
    }

    private static void z(Context context, String str, bv bvVar) {
        if (TextUtils.isEmpty(str) || context == null) {
            return;
        }
        bvVar.gc().edit().putString("google_aid", str).apply();
    }
}
