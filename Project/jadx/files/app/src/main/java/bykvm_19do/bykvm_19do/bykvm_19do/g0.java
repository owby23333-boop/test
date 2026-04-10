package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

/* JADX INFO: loaded from: classes.dex */
public class g0 {
    private static volatile String a;

    public static String a(Context context, j2 j2Var) {
        AdvertisingIdClient.Info advertisingIdInfo;
        if (TextUtils.isEmpty(a)) {
            synchronized (g0.class) {
                if (!TextUtils.isEmpty(a)) {
                    return a;
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
                    id = j2Var.w().getString("google_aid", null);
                } else if (!TextUtils.equals(j2Var.w().getString("google_aid", null), id)) {
                    a(context, id, j2Var);
                }
                a = id;
            }
        }
        return a;
    }

    private static void a(Context context, String str, j2 j2Var) {
        if (TextUtils.isEmpty(str) || context == null) {
            return;
        }
        j2Var.w().edit().putString("google_aid", str).apply();
    }
}
