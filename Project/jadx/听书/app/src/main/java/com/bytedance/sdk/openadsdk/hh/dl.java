package com.bytedance.sdk.openadsdk.hh;

import android.os.Environment;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    public static String z() {
        try {
            return Environment.getExternalStorageState();
        } catch (Throwable unused) {
            return "";
        }
    }
}
