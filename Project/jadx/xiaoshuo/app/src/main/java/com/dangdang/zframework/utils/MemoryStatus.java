package com.dangdang.zframework.utils;

import android.os.Environment;
import android.os.StatFs;

/* JADX INFO: loaded from: classes10.dex */
public class MemoryStatus {
    protected static final int ERROR = -1;
    public static final int MIN_SPACE = 10485760;

    public static boolean externalMemoryAvailable() {
        return false;
    }

    public static String formatSize(long j) {
        String str;
        if (j >= 1024) {
            j /= 1024;
            if (j >= 1024) {
                j /= 1024;
                str = "MiB";
            } else {
                str = "KiB";
            }
        } else {
            str = null;
        }
        StringBuilder sb = new StringBuilder(Long.toString(j));
        for (int length = sb.length() - 3; length > 0; length -= 3) {
            sb.insert(length, ',');
        }
        if (str != null) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static long getAvailableExternalMemorySize() {
        return -1L;
    }

    public static long getAvailableInternalMemorySize() {
        long blockSize;
        long availableBlocks = 0;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            blockSize = statFs.getBlockSize();
            try {
                availableBlocks = statFs.getAvailableBlocks();
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
            }
        } catch (Exception e2) {
            e = e2;
            blockSize = 0;
        }
        return availableBlocks * blockSize;
    }

    public static long getTotalExternalMemorySize() {
        return -1L;
    }

    public static long getTotalInternalMemorySize() {
        long blockSize;
        long blockCount = 0;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            blockSize = statFs.getBlockSize();
            try {
                blockCount = statFs.getBlockCount();
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
            }
        } catch (Exception e2) {
            e = e2;
            blockSize = 0;
        }
        return blockCount * blockSize;
    }

    public static boolean hasAvailable(int i, int i2) {
        return getAvailableExternalMemorySize() - ((long) i2) > ((long) i);
    }

    public static boolean hasMemAvailable() {
        return getAvailableInternalMemorySize() >= 10485760;
    }

    public static boolean isSdcardAndMemAvailable(long j) {
        return externalMemoryAvailable() ? getAvailableExternalMemorySize() >= j : getAvailableInternalMemorySize() >= j;
    }
}
