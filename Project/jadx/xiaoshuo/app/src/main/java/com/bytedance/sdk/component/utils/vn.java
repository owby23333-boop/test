package com.bytedance.sdk.component.utils;

import android.content.Context;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class vn {

    /* JADX INFO: renamed from: com.bytedance.sdk.component.utils.vn$1, reason: invalid class name */
    public static class AnonymousClass1 implements Comparator<File> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            long jLastModified = file2.lastModified() - file.lastModified();
            if (jLastModified == 0) {
                return 0;
            }
            return jLastModified < 0 ? -1 : 1;
        }
    }

    public static final class e implements Comparator<File> {
        private e() {
        }

        private int e(long j, long j2) {
            if (j < j2) {
                return -1;
            }
            return j == j2 ? 0 : 1;
        }

        public /* synthetic */ e(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return e(file.lastModified(), file2.lastModified());
        }
    }

    public static File bf(Context context, boolean z, String str, String str2) {
        String strD = d(context);
        if (z) {
            str = e(context) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str;
        }
        if (strD != null) {
            String str3 = File.separator;
            if (!strD.endsWith(str3)) {
                strD = strD + str3;
            }
        }
        String str4 = strD + str;
        File file = new File(str4);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(str4, str2);
    }

    private static String d(Context context) {
        File cacheDir;
        if (context == null || (cacheDir = context.getCacheDir()) == null) {
            return null;
        }
        return cacheDir.getPath();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.io.File e(android.content.Context r1, boolean r2, java.lang.String r3, java.lang.String r4) {
        /*
            java.lang.String r0 = bf(r1)
            if (r2 == 0) goto L1f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r1 = e(r1)
            r2.append(r1)
            java.lang.String r1 = "-"
            r2.append(r1)
            r2.append(r3)
            java.lang.String r1 = r2.toString()
            goto L30
        L1f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "/"
            r1.append(r2)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
        L30:
            if (r0 == 0) goto L4a
            java.lang.String r2 = java.io.File.separator
            boolean r3 = r0.endsWith(r2)
            if (r3 != 0) goto L4a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            goto L4c
        L4a:
            java.lang.String r2 = ""
        L4c:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            java.io.File r2 = new java.io.File
            r2.<init>(r1)
            boolean r3 = r2.exists()
            if (r3 != 0) goto L69
            r2.mkdirs()
        L69:
            java.io.File r2 = new java.io.File
            r2.<init>(r1, r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.utils.vn.e(android.content.Context, boolean, java.lang.String, java.lang.String):java.io.File");
    }

    private static void ga(File file) throws IOException {
        RandomAccessFile randomAccessFile;
        long j;
        long length = file.length();
        if (length == 0) {
            vn(file);
            return;
        }
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rwd");
            j = length - 1;
        } catch (Throwable unused) {
        }
        try {
            randomAccessFile.seek(j);
            byte b2 = randomAccessFile.readByte();
            randomAccessFile.seek(j);
            randomAccessFile.write(b2);
            randomAccessFile.close();
        } catch (Throwable unused2) {
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
        }
    }

    public static byte[] tg(File file) {
        FileInputStream fileInputStream;
        if (file != null && file.isFile() && file.exists() && file.canRead() && file.length() > 0) {
            try {
                Long lValueOf = Long.valueOf(file.length());
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[lValueOf.intValue()];
                    if (fileInputStream.read(bArr) == lValueOf.longValue()) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused) {
                        }
                        return bArr;
                    }
                } catch (Throwable unused2) {
                    if (fileInputStream != null) {
                    }
                    return null;
                }
            } catch (Throwable unused3) {
                fileInputStream = null;
            }
            try {
                fileInputStream.close();
            } catch (Throwable unused4) {
            }
        }
        return null;
    }

    private static void vn(File file) throws IOException {
        if (file.delete() && file.createNewFile()) {
            return;
        }
        throw new IOException("Error recreate zero-size file " + file);
    }

    public static void d(File file) {
        File[] fileArrListFiles;
        if (file == null || !file.exists()) {
            return;
        }
        try {
            if (!file.isFile() && (fileArrListFiles = file.listFiles()) != null && fileArrListFiles.length > 0) {
                for (File file2 : fileArrListFiles) {
                    if (file2.isDirectory()) {
                        d(file2);
                    } else {
                        try {
                            file2.delete();
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
            file.delete();
        } catch (Throwable unused2) {
        }
    }

    public static File bf(Context context, boolean z, String str) {
        String absolutePath = context.getCacheDir().getAbsolutePath();
        if (z) {
            str = e(context) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str;
        }
        if (absolutePath != null) {
            String str2 = File.separator;
            if (!absolutePath.endsWith(str2)) {
                absolutePath = absolutePath + str2;
            }
        }
        File file = new File(absolutePath + str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.io.File e(android.content.Context r1, boolean r2, java.lang.String r3) {
        /*
            java.lang.String r0 = bf(r1)
            if (r2 == 0) goto L1e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r1 = e(r1)
            r2.append(r1)
            java.lang.String r1 = "-"
            r2.append(r1)
            r2.append(r3)
            java.lang.String r3 = r2.toString()
        L1e:
            if (r0 == 0) goto L38
            java.lang.String r1 = java.io.File.separator
            boolean r2 = r0.endsWith(r1)
            if (r2 != 0) goto L38
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            goto L3a
        L38:
            java.lang.String r1 = ""
        L3a:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            r2.append(r3)
            java.lang.String r1 = r2.toString()
            java.io.File r2 = new java.io.File
            r2.<init>(r1)
            boolean r1 = r2.exists()
            if (r1 != 0) goto L57
            r2.mkdirs()
        L57:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.utils.vn.e(android.content.Context, boolean, java.lang.String):java.io.File");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String bf(android.content.Context r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            r1 = 0
            java.lang.String r2 = "mounted"
            java.lang.String r3 = android.os.Environment.getExternalStorageState()     // Catch: java.lang.Throwable -> L19
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Throwable -> L19
            if (r2 != 0) goto L17
            boolean r2 = android.os.Environment.isExternalStorageRemovable()     // Catch: java.lang.Throwable -> L19
            if (r2 != 0) goto L1d
        L17:
            r1 = 1
            goto L1d
        L19:
            r2 = move-exception
            r2.printStackTrace()
        L1d:
            if (r1 == 0) goto L26
            java.io.File r1 = r4.getExternalCacheDir()     // Catch: java.lang.Throwable -> L24
            goto L27
        L24:
            r1 = r0
            goto L2d
        L26:
            r1 = r0
        L27:
            if (r1 != 0) goto L2d
            java.io.File r1 = r4.getCacheDir()     // Catch: java.lang.Throwable -> L2d
        L2d:
            if (r1 != 0) goto L30
            goto L34
        L30:
            java.lang.String r0 = r1.getPath()
        L34:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.utils.vn.bf(android.content.Context):java.lang.String");
    }

    public static List<File> e(File file) {
        LinkedList linkedList = new LinkedList();
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return linkedList;
        }
        List<File> listAsList = Arrays.asList(fileArrListFiles);
        Collections.sort(listAsList, new e(null));
        return listAsList;
    }

    public static String e(Context context) {
        String strE = f.e(context);
        return strE.contains(":") ? strE.replace(":", Constants.ACCEPT_TIME_SEPARATOR_SERVER) : strE;
    }

    public static void bf(File file) throws IOException {
        if (file.exists()) {
            wu.vn("splashLoadAd", "update file modify time");
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (file.setLastModified(jCurrentTimeMillis)) {
                return;
            }
            ga(file);
            if (file.lastModified() < jCurrentTimeMillis) {
                wu.tg("Files", "Last modified date " + new Date(file.lastModified()) + " is not set for file " + file.getAbsolutePath());
            }
        }
    }
}
