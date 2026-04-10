package com.bytedance.sdk.openadsdk.core;

import android.annotation.SuppressLint;
import android.content.Context;

/* JADX INFO: loaded from: classes10.dex */
public class v extends zk {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile v e;

    private v(Context context) {
        super(context);
    }

    public static v e(Context context) {
        if (e == null) {
            synchronized (v.class) {
                if (e == null) {
                    e = new v(context);
                }
            }
        }
        return e;
    }
}
