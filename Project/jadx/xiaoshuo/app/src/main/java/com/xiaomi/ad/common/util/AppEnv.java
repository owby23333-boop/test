package com.xiaomi.ad.common.util;

import android.content.Context;
import android.os.Environment;
import android.os.Process;
import java.io.File;

/* JADX INFO: loaded from: classes5.dex */
public final class AppEnv {
    public static File getExternalStorageDirFile(Context context, String str, String str2) {
        if (!Environment.isExternalStorageEmulated() || !isPermissionGranted(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            return null;
        }
        File file = new File(Environment.getExternalStorageDirectory(), str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file.getAbsolutePath(), str2);
    }

    public static File getFilesDirFile(Context context, String str, String str2) {
        File file = new File(context.getFilesDir(), str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file.getAbsolutePath(), str2);
    }

    public static boolean isPermissionGranted(Context context, String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }
}
