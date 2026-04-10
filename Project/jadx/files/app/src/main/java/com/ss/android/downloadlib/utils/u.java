package com.ss.android.downloadlib.utils;

import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class u {
    public static long mb(File file) {
        if (file == null || !file.exists()) {
            return 0L;
        }
        return mb(file, file.lastModified(), 0);
    }

    private static long mb(File file, long j2, int i2) {
        File[] fileArrListFiles;
        if (file != null && file.exists()) {
            j2 = Math.max(j2, file.lastModified());
            int i3 = i2 + 1;
            if (i3 >= 50) {
                return j2;
            }
            if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
                for (File file2 : fileArrListFiles) {
                    j2 = Math.max(j2, mb(file2, j2, i3));
                }
            }
        }
        return j2;
    }
}
