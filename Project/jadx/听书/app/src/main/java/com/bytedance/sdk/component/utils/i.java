package com.bytedance.sdk.component.utils;

import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class i {
    public static long z(String str) {
        long availableBlocks = 0;
        try {
            if (!TextUtils.isEmpty(str)) {
                StatFs statFs = new StatFs(str);
                availableBlocks = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
            }
        } catch (Throwable unused) {
        }
        String.valueOf(str);
        return availableBlocks;
    }

    public static long z() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Throwable unused) {
            return 0L;
        }
    }
}
