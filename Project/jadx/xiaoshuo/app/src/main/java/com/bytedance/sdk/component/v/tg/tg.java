package com.bytedance.sdk.component.v.tg;

import android.util.Log;
import com.bytedance.sdk.component.utils.wu;

/* JADX INFO: loaded from: classes.dex */
public class tg {
    private static int bf = 4;
    private static boolean e = false;

    public static void bf(String str, String str2) {
        if (e && str2 != null && bf <= 4) {
            Log.i(wu.tg(str), str2);
        }
    }

    public static boolean e() {
        return e;
    }

    public static void e(String str) {
        e("NetLog", str);
    }

    public static void e(String str, String str2) {
        if (e && str2 != null && bf <= 2) {
            Log.v(wu.tg(str), str2);
        }
    }
}
