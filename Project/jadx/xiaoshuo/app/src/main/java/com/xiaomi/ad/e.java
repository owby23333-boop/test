package com.xiaomi.ad;

import android.text.TextUtils;
import com.xiaomi.ad.common.util.MLog;
import com.xiaomi.ad.common.util.SignatureUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f7259a = "FileUtils";

    public static String a(File file) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        String str = null;
        try {
            if (file == null) {
                return null;
            }
            try {
                fileInputStream = new FileInputStream(file);
            } catch (IOException e) {
                e = e;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                String str2 = new String(bArr);
                f.a((Closeable) fileInputStream);
                str = str2;
            } catch (IOException e2) {
                e = e2;
                e.printStackTrace();
                f.a((Closeable) fileInputStream);
            }
            return str;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
        }
        f.a((Closeable) fileInputStream2);
        throw th;
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    public static boolean a(String str, File file) {
        if (str == null) {
            return false;
        }
        return a((str + SignatureUtils.DELIMITER).getBytes(), file);
    }

    public static boolean a(byte[] bArr, File file) throws Throwable {
        if (bArr == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(bArr);
                    fileOutputStream2.flush();
                    f.a(fileOutputStream2);
                    return true;
                } catch (Exception e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    MLog.e("FileUtils", "saveBytesToFile exception", e);
                    if (file.exists()) {
                        file.delete();
                    }
                    f.a(fileOutputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    f.a(fileOutputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
