package com.kwad.components.core.i;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.kwad.sdk.core.config.d;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static boolean ak(Context context) {
        boolean zH;
        if (context == null) {
            return false;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("ksadsdk_local_ad_force_active", 0);
        a aVar = new a();
        if (sharedPreferences.contains("ksadsdk_local_ad_force_active_data")) {
            String string = sharedPreferences.getString("ksadsdk_local_ad_force_active_data", null);
            if (!TextUtils.isEmpty(string)) {
                try {
                    aVar.parseJson(new JSONObject(string));
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
                }
            }
            zH = aVar.h(d.uN(), d.uO());
            com.kwad.sdk.core.d.b.d("LocalAdForceActiveHelper", "addCount contains success: " + zH);
        } else {
            com.kwad.sdk.core.d.b.d("LocalAdForceActiveHelper", "addCount not contains");
            aVar.nZ();
            zH = true;
        }
        if (zH) {
            sharedPreferences.edit().putString("ksadsdk_local_ad_force_active_data", aVar.toJson().toString()).apply();
        }
        return zH;
    }
}
