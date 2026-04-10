package com.bytedance.e.e.v;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class m {
    public static void bf(Throwable th) {
        if (com.bytedance.e.e.zk.ga().tg()) {
            Log.w("npth", "NPTH Catch Error", th);
        }
    }

    public static void e(String str) {
        if (com.bytedance.e.e.zk.ga().tg()) {
            Log.i("npth", str);
        }
    }

    public static void e(Throwable th) {
        if (com.bytedance.e.e.zk.ga().tg()) {
            Log.e("npth", "NPTH Catch Error", th);
        }
    }
}
