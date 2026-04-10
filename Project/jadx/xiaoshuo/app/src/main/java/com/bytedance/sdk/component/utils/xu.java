package com.bytedance.sdk.component.utils;

import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class xu {
    public static long e(String str) {
        StringBuilder sb;
        long availableBlocks = 0;
        try {
            if (!TextUtils.isEmpty(str)) {
                StatFs statFs = new StatFs(str);
                availableBlocks = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
            }
            sb = new StringBuilder();
        } catch (Throwable unused) {
            sb = new StringBuilder();
        }
        sb.append("getAvailableSize=");
        sb.append(availableBlocks);
        sb.append(", ");
        sb.append(String.valueOf(str));
        wu.bf("MemorySize", sb.toString());
        return availableBlocks;
    }

    public static long e() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Throwable unused) {
            return 0L;
        }
    }
}
