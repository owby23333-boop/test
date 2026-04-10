package com.bytedance.sdk.openadsdk.s;

import android.os.Environment;

/* JADX INFO: loaded from: classes10.dex */
public class d {
    public static String e() {
        try {
            return Environment.getExternalStorageState();
        } catch (Throwable unused) {
            return "";
        }
    }
}
