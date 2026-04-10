package com.miui.zeus.landingpage.sdk;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.market.sdk.utils.AppGlobal;
import java.lang.ref.WeakReference;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public class LandingPageSDK {
    public static void init(Context context) {
        if (context == null) {
            h.b("LandingPageSDK", "context is null , stop init");
            return;
        }
        if (h.f7199a >= 2) {
            h.a(h.a("LandingPageSDK"), "LandingPageSDK init 1.1.10", 2);
        }
        AppGlobal.setContext(context);
        if (f.f7197a == null) {
            f.f7197a = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        }
        if (f.f7198b == null && (context instanceof Activity)) {
            f.f7198b = new WeakReference<>((Activity) context);
        }
        if (TextUtils.isEmpty(f.f)) {
            f.f = UUID.randomUUID().toString();
        }
    }

    public static boolean isDebugOn() {
        return f.e;
    }

    public static void setDebugOn(boolean z) {
        f.e = z;
        h.f7199a = 1000;
    }
}
