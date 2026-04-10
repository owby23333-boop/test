package com.miui.zeus.landingpage.sdk;

import android.content.Context;
import android.content.Intent;
import com.xiaomi.ad.common.util.AndroidUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static boolean a(Context context, String str) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage == null) {
                return false;
            }
            context.startActivity(launchIntentForPackage);
            return true;
        } catch (Exception e) {
            h.a(AndroidUtils.TAG, "startAppWithPackageName exception", e);
            return false;
        }
    }
}
