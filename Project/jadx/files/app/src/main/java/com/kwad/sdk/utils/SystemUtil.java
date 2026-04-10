package com.kwad.sdk.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes3.dex */
public final class SystemUtil {
    private static long azC;
    private static long azD;
    private static int azE;
    private static LEVEL azF;

    public enum LEVEL {
        BEST(5),
        HIGH(4),
        MIDDLE(3),
        LOW(2),
        BAD(1),
        UN_KNOW(-1);

        int value;

        LEVEL(int i2) {
            this.value = i2;
        }

        public final int getValue() {
            return this.value;
        }
    }

    public static class a {
        public long azG;
        public long azH;
        public long azI;
        public long azJ;
        public long azK;
        public int mThreadsCount;
    }

    public static long Ew() throws Throwable {
        BufferedReader bufferedReader;
        Throwable th;
        String line;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            do {
                try {
                    line = bufferedReader.readLine();
                    if (line == null) {
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return 0L;
                    }
                } catch (Exception unused) {
                    bufferedReader2 = bufferedReader;
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                    return 0L;
                } catch (Throwable th2) {
                    th = th2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                    throw th;
                }
            } while (!line.contains("MemTotal"));
            long jLongValue = Long.valueOf(line.split("\\s+")[1]).longValue() << 10;
            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
            return jLongValue;
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }

    public static a Ex() throws Throwable {
        RandomAccessFile randomAccessFile;
        String strAf;
        a aVar = new a();
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile("/proc/self/status", "r");
            while (true) {
                try {
                    String line = randomAccessFile.readLine();
                    if (line == null) {
                        break;
                    }
                    if (!TextUtils.isEmpty(line)) {
                        if (line.startsWith("VmSize") && line.contains("kB")) {
                            String strAf2 = af(line, "VmSize");
                            if (strAf2 != null) {
                                aVar.azH = Long.valueOf(strAf2).longValue();
                            }
                        } else if (line.startsWith("VmRSS:") && line.contains("kB")) {
                            String strAf3 = af(line, "VmRSS:");
                            if (strAf3 != null) {
                                aVar.azI = Long.valueOf(strAf3).longValue();
                            }
                        } else if (line.startsWith("Threads:") && (strAf = af(line, "Threads:")) != null) {
                            aVar.mThreadsCount = Integer.valueOf(strAf).intValue();
                        }
                    }
                } catch (IOException unused) {
                    randomAccessFile2 = randomAccessFile;
                    com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile2);
                } catch (Throwable th) {
                    th = th;
                    com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile);
                    throw th;
                }
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile);
        } catch (IOException unused2) {
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
        return aVar;
    }

    private static String af(String str, String str2) {
        int length = str2.length();
        int i2 = -1;
        while (true) {
            if (length >= str.length()) {
                length = -1;
                break;
            }
            char cCharAt = str.charAt(length);
            if (cCharAt < '0' || cCharAt > '9') {
                if (i2 != -1) {
                    break;
                }
            } else if (i2 == -1) {
                i2 = length;
            }
            length++;
        }
        if (i2 == -1) {
            return null;
        }
        return length == -1 ? str.substring(i2) : str.substring(i2, length);
    }

    public static boolean b(Context context, @NonNull String... strArr) {
        if (context == null) {
            return false;
        }
        for (int i2 = 0; i2 <= 0; i2++) {
            try {
                if (context.checkPermission(strArr[0], Process.myPid(), Process.myUid()) == -1) {
                    return false;
                }
            } catch (Exception unused) {
                return true;
            }
        }
        return true;
    }

    public static boolean cd(int i2) {
        return getApiLevel() >= i2;
    }

    public static void checkUiThread() {
    }

    public static boolean dd(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return false;
        }
        return b(context, "android.permission.READ_PHONE_STATE");
    }

    public static long de(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    private static int getApiLevel() {
        return Build.VERSION.SDK_INT;
    }

    @Nullable
    public static String getProcessName(Context context) {
        return ao.getProcessName(context);
    }

    public static boolean isInMainProcess(Context context) {
        return ao.isInMainProcess(context);
    }
}
