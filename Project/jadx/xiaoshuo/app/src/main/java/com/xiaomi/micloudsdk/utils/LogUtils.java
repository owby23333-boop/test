package com.xiaomi.micloudsdk.utils;

import android.content.Context;
import android.util.Log;
import com.yuewen.et;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes8.dex */
public class LogUtils {
    private static final int LOG_COUNT_LIMIT_MAX = 6;
    private static final int LOG_COUNT_LIMIT_RESET = 3;
    private static final String LOG_FILE_EXTENSION = ".log.gz";
    private static final String LOG_FILE_PREFIX = "dump_";
    private static final String TAG = "LogUtils";

    private static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private static String getLogFilePrefix(String str) {
        return LOG_FILE_PREFIX + str + "_";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.Closeable, java.io.OutputStream, java.util.zip.GZIPOutputStream] */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.lang.Process] */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v8 */
    public static void saveLog(Context context, String str) throws Throwable {
        Process processStart;
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir == null) {
            Log.d(TAG, "Cancel saving log for external disk is not found");
            return;
        }
        trimLogs(externalCacheDir, str);
        ?? sb = new StringBuilder();
        sb.append(externalCacheDir.getAbsolutePath());
        sb.append(File.separator);
        sb.append(getLogFilePrefix(str));
        sb.append(System.currentTimeMillis());
        sb.append(LOG_FILE_EXTENSION);
        ?? string = sb.toString();
        InputStream inputStream = null;
        try {
            try {
                sb = new GZIPOutputStream(new BufferedOutputStream(new FileOutputStream((String) string)));
            } catch (IOException e) {
                e = e;
                processStart = null;
                sb = 0;
            } catch (Throwable th) {
                th = th;
                string = 0;
                sb = 0;
            }
            try {
                processStart = new ProcessBuilder(new String[0]).command("/system/bin/logcat", "-v", et.j, "-d").redirectErrorStream(true).start();
            } catch (IOException e2) {
                e = e2;
                processStart = null;
            } catch (Throwable th2) {
                th = th2;
                string = 0;
                closeQuietly(null);
                closeQuietly(sb);
                if (string != 0) {
                    string.destroy();
                }
                throw th;
            }
            try {
                inputStream = processStart.getInputStream();
                byte[] bArr = new byte[8192];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i <= 0) {
                        break;
                    } else {
                        sb.write(bArr, 0, i);
                    }
                }
                closeQuietly(inputStream);
                closeQuietly(sb);
            } catch (IOException e3) {
                e = e3;
                Log.e(TAG, "Fail to create logcat process", e);
                closeQuietly(inputStream);
                closeQuietly(sb);
                if (processStart == null) {
                    return;
                }
            }
            processStart.destroy();
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private static void trimLogs(File file, String str) {
        final String logFilePrefix = getLogFilePrefix(str);
        File[] fileArrListFiles = file.listFiles(new FilenameFilter() { // from class: com.xiaomi.micloudsdk.utils.LogUtils.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str2) {
                return str2.startsWith(logFilePrefix);
            }
        });
        if (fileArrListFiles.length >= 6) {
            ArrayList arrayList = new ArrayList(fileArrListFiles.length);
            Collections.addAll(arrayList, fileArrListFiles);
            Collections.sort(arrayList, new Comparator<File>() { // from class: com.xiaomi.micloudsdk.utils.LogUtils.2
                @Override // java.util.Comparator
                public int compare(File file2, File file3) {
                    return (int) (file2.lastModified() - file3.lastModified());
                }
            });
            int size = arrayList.size() - 3;
            for (int i = 0; i < size; i++) {
                ((File) arrayList.get(i)).delete();
            }
        }
    }
}
