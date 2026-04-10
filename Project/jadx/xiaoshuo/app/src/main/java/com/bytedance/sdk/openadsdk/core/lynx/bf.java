package com.bytedance.sdk.openadsdk.core.lynx;

import android.app.Application;
import android.content.Context;
import com.bytedance.sdk.component.utils.wu;
import com.bytedance.sdk.openadsdk.core.lc;

/* JADX INFO: loaded from: classes10.dex */
public class bf {
    private static volatile boolean e = false;

    public static void bf() {
        wu.tg("lynx-adsdk", "not install lynx plugin");
    }

    public static void d() {
    }

    public static boolean e() {
        return e;
    }

    public static String ga() {
        return "";
    }

    private static Application getContext() {
        Context context = lc.getContext();
        if (context instanceof Application) {
            return (Application) context;
        }
        try {
            return (Application) context.getApplicationContext();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String tg() {
        return "";
    }
}
