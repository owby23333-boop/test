package com.ss.android.downloadlib.p;

import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
public class p {
    public static long e(File file) {
        if (file == null || !file.exists()) {
            return 0L;
        }
        return e(file, file.lastModified(), 0);
    }

    private static long e(File file, long j, int i) {
        File[] fileArrListFiles;
        if (file != null && file.exists()) {
            j = Math.max(j, file.lastModified());
            int i2 = i + 1;
            if (i2 >= 50) {
                return j;
            }
            if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
                for (File file2 : fileArrListFiles) {
                    j = Math.max(j, e(file2, j, i2));
                }
            }
        }
        return j;
    }
}
