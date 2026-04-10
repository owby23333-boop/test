package com.iflytek.aikit.utils;

import android.content.Context;
import android.os.Environment;
import android.os.MemoryFile;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.iflytek.aikit.media.record.WavWriter;
import com.iflytek.aikit.utils.log.LogUtil;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes7.dex */
public class FileUtil {
    private static final String CHILD_FOLDER_NAME = "res";
    private static final String FOLDER_NAME = "msc";
    private static final String FORMAT_PCM = "pcm";
    private static final String FORMAT_WAV = "wav";
    public static final String RES_SUFFIX = ".jet";
    private static String userPath = "";

    public static boolean checkFileMD5(String str, String str2) {
        if (str.equals(Encrypter.getFileMd5(new File(str2)))) {
            return true;
        }
        deleteFile(str2);
        return false;
    }

    public static String codeString(File file) {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            int i = (bufferedInputStream.read() << 8) + bufferedInputStream.read();
            return i != 4094 ? i != 61371 ? i != 65279 ? "GBK" : "YTF-16BE" : "UTF-8" : "Unicode";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void copyAssetsFile(Context context, String str, String str2) throws Throwable {
        FileOutputStream fileOutputStream;
        InputStream inputStreamOpen;
        InputStream inputStream = null;
        try {
            inputStreamOpen = context.getAssets().open(str);
            try {
                makeDir(str2);
                fileOutputStream = new FileOutputStream(str2, false);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
        try {
            byte[] bArr = new byte[2048];
            while (true) {
                int i = inputStreamOpen.read(bArr);
                if (i <= 0) {
                    inputStreamOpen.close();
                    fileOutputStream.close();
                    return;
                }
                fileOutputStream.write(bArr, 0, i);
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = inputStreamOpen;
            if (inputStream != null) {
                inputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }

    public static void deleteFile(String str) {
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }

    public static boolean formatPcm(String str, String str2, int i) {
        if (TextUtils.isEmpty(str) || FORMAT_PCM.equals(str)) {
            return true;
        }
        if (FORMAT_WAV.equals(str)) {
            return pcm2Wav(str2, i);
        }
        LogUtil.e("format not supported");
        return false;
    }

    public static String getResFilePath(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = System.currentTimeMillis() + "";
        }
        String absolutePath = "mounted".equals(Environment.getExternalStorageState()) ? Environment.getExternalStorageDirectory().getAbsolutePath() : context.getFilesDir().getAbsolutePath();
        if (!absolutePath.endsWith("/")) {
            absolutePath = absolutePath + "/";
        }
        String str2 = (absolutePath + "msc/") + "res/";
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str3 = str2 + str;
        if (str3.endsWith(RES_SUFFIX)) {
            return str3;
        }
        return str3 + RES_SUFFIX;
    }

    public static String getUserPath(Context context) {
        if (!TextUtils.isEmpty(userPath)) {
            return userPath;
        }
        String absolutePath = context.getFilesDir().getAbsolutePath();
        if (!absolutePath.endsWith("/")) {
            absolutePath = absolutePath + "/";
        }
        String str = absolutePath + "msclib/";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        userPath = str;
        return str;
    }

    public static void makeDir(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (!str.endsWith("/")) {
            file = file.getParentFile();
        }
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    public static boolean pcm2Wav(String str, int i) {
        try {
            WavWriter wavWriter = new WavWriter(new File(str), i);
            wavWriter.writeHeader();
            wavWriter.close();
            return true;
        } catch (IOException e) {
            LogUtil.e(e);
            return false;
        }
    }

    public static byte[] readFile(String str) throws Throwable {
        Throwable th;
        FileInputStream fileInputStream;
        byte[] bArr;
        FileInputStream fileInputStream2 = null;
        byte[] bArr2 = null;
        fileInputStream2 = null;
        try {
            try {
                File file = new File(str);
                if (!file.exists()) {
                    return null;
                }
                fileInputStream = new FileInputStream(file);
                try {
                    bArr2 = new byte[fileInputStream.available()];
                    fileInputStream.read(bArr2);
                    try {
                        fileInputStream.close();
                        return bArr2;
                    } catch (IOException e) {
                        LogUtil.e(e);
                        return bArr2;
                    }
                } catch (Exception e2) {
                    e = e2;
                    byte[] bArr3 = bArr2;
                    fileInputStream2 = fileInputStream;
                    bArr = bArr3;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            LogUtil.e(e3);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                FileInputStream fileInputStream3 = fileInputStream2;
                th = th3;
                fileInputStream = fileInputStream3;
            }
        } catch (Exception e4) {
            e = e4;
            bArr = null;
        }
        LogUtil.e(e);
        if (fileInputStream2 != null) {
            try {
                fileInputStream2.close();
            } catch (IOException e5) {
                LogUtil.e(e5);
            }
        }
        return bArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r0v6 */
    public static byte[] readFileFromAssets(Context context, String str) throws Throwable {
        byte[] bArr;
        ?? r0 = 0;
        byte[] bArr2 = null;
        InputStream inputStream = null;
        try {
            try {
                InputStream inputStreamOpen = context.getAssets().open(str);
                try {
                    bArr2 = new byte[inputStreamOpen.available()];
                    inputStreamOpen.read(bArr2);
                    try {
                        inputStreamOpen.close();
                        r0 = bArr2;
                    } catch (IOException e) {
                        LogUtil.e(e);
                        r0 = bArr2;
                    }
                } catch (Exception e2) {
                    e = e2;
                    byte[] bArr3 = bArr2;
                    inputStream = inputStreamOpen;
                    bArr = bArr3;
                    LogUtil.e(e);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                            LogUtil.e(e3);
                        }
                    }
                    r0 = bArr;
                } catch (Throwable th) {
                    th = th;
                    r0 = inputStreamOpen;
                    if (r0 != 0) {
                        try {
                            r0.close();
                        } catch (IOException e4) {
                            LogUtil.e(e4);
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                bArr = null;
            }
            return r0;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean saveFile(MemoryFile memoryFile, long j, String str) throws Throwable {
        if (memoryFile == null || TextUtils.isEmpty(str)) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                deleteFile(str);
                makeDir(str);
                FileOutputStream fileOutputStream2 = new FileOutputStream(str);
                try {
                    byte[] bArr = new byte[65536];
                    int i = 0;
                    while (true) {
                        long j2 = i;
                        if (j2 < j) {
                            long j3 = j - j2;
                            if (j3 > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                                j3 = 65536;
                            }
                            int i2 = (int) j3;
                            memoryFile.readBytes(bArr, i, 0, i2);
                            fileOutputStream2.write(bArr, 0, i2);
                            i += i2;
                        } else {
                            try {
                                break;
                            } catch (Exception unused) {
                            }
                        }
                    }
                    fileOutputStream2.close();
                    return true;
                } catch (Exception e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    LogUtil.e(e);
                    if (fileOutputStream == null) {
                        return false;
                    }
                    try {
                        fileOutputStream.close();
                        return false;
                    } catch (Exception unused2) {
                        return false;
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x003c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean saveFile(byte[] r3, java.lang.String r4, boolean r5, int r6) throws java.lang.Throwable {
        /*
            r0 = 0
            if (r5 != 0) goto L6
            deleteFile(r4)     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
        L6:
            makeDir(r4)     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            java.lang.String r2 = "rw"
            r1.<init>(r4, r2)     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            if (r5 != 0) goto L1e
            r4 = 0
            r1.setLength(r4)     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L1b
            goto L2c
        L18:
            r3 = move-exception
            r0 = r1
            goto L41
        L1b:
            r3 = move-exception
            r0 = r1
            goto L37
        L1e:
            if (r6 >= 0) goto L28
            long r4 = r1.length()     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L1b
            r1.seek(r4)     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L1b
            goto L2c
        L28:
            long r4 = (long) r6     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L1b
            r1.seek(r4)     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L1b
        L2c:
            r1.write(r3)     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L1b
            r1.close()     // Catch: java.lang.Exception -> L32
        L32:
            r3 = 1
            goto L40
        L34:
            r3 = move-exception
            goto L41
        L36:
            r3 = move-exception
        L37:
            com.iflytek.aikit.utils.log.LogUtil.e(r3)     // Catch: java.lang.Throwable -> L34
            if (r0 == 0) goto L3f
            r0.close()     // Catch: java.lang.Exception -> L3f
        L3f:
            r3 = 0
        L40:
            return r3
        L41:
            if (r0 == 0) goto L46
            r0.close()     // Catch: java.lang.Exception -> L46
        L46:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.aikit.utils.FileUtil.saveFile(byte[], java.lang.String, boolean, int):boolean");
    }

    public static boolean saveFile(ConcurrentLinkedQueue<byte[]> concurrentLinkedQueue, String str) throws Throwable {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                makeDir(str);
                FileOutputStream fileOutputStream2 = new FileOutputStream(str);
                try {
                    Iterator<byte[]> it = concurrentLinkedQueue.iterator();
                    while (it.hasNext()) {
                        fileOutputStream2.write(it.next());
                    }
                    fileOutputStream2.close();
                    return true;
                } catch (Exception e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    LogUtil.e(e);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e2) {
                            LogUtil.e(e2);
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e3) {
                            LogUtil.e(e3);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e4) {
            e = e4;
        }
    }
}
