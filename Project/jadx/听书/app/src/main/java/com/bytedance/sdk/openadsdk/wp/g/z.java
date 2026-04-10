package com.bytedance.sdk.openadsdk.wp.g;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.sdk.component.utils.wp;
import com.google.common.base.Ascii;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class z {
    private static final byte[] z = {71, 73, 70, 56, 55, 97};
    private static final byte[] g = {71, 73, 70, 56, 57, 97};
    private static final byte[] dl = {-1, -40, -1};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f1498a = {-119, 80, 78, 71, 13, 10, Ascii.SUB, 10};

    public static byte[] z(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        try {
            return z(new FileInputStream(file));
        } catch (Exception e) {
            wp.z(e);
            return null;
        }
    }

    public static boolean z(InputStream inputStream, String str, String str2, long j) throws Throwable {
        File file;
        File file2;
        if (inputStream == null) {
            return false;
        }
        long j2 = j != -2147483648L ? j * PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED : 1099511627776L;
        FileOutputStream fileOutputStream = null;
        long j3 = 0;
        try {
            File file3 = new File(str);
            if (!file3.exists() && !file3.mkdirs()) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e) {
                        wp.z(e);
                    }
                }
                return false;
            }
            file2 = new File(file3, str2);
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = inputStream.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        fileOutputStream2.write(bArr, 0, i);
                        j3 += (long) i;
                    }
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                    inputStream.close();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e2) {
                            wp.z(e2);
                            return true;
                        }
                    }
                    if (j == -2147483648L || j3 <= j2) {
                        return true;
                    }
                    file2.delete();
                    return false;
                } catch (Exception unused) {
                    fileOutputStream = fileOutputStream2;
                } catch (Throwable th) {
                    file = file2;
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e3) {
                            wp.z(e3);
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e4) {
                            wp.z(e4);
                            throw th;
                        }
                    }
                    if (j == -2147483648L || j3 <= j2 || file == null) {
                        throw th;
                    }
                    file.delete();
                    return false;
                }
            } catch (Exception unused2) {
            } catch (Throwable th2) {
                file = file2;
                th = th2;
            }
        } catch (Exception unused3) {
            file2 = null;
        } catch (Throwable th3) {
            th = th3;
            file = null;
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (Exception e5) {
                wp.z(e5);
            }
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e6) {
                wp.z(e6);
            }
        }
        if (j != -2147483648L && j3 > j2 && file2 != null) {
            file2.delete();
            return false;
        }
        return false;
    }

    public static void g(String str) throws Exception {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            int length = fileArrListFiles.length;
            for (int i = 0; i < length; i++) {
                if (fileArrListFiles[i].isDirectory()) {
                    g(fileArrListFiles[i].getAbsolutePath());
                } else {
                    fileArrListFiles[i].delete();
                }
            }
            file.delete();
        }
    }

    public static byte[] z(InputStream inputStream) {
        if (inputStream == null) {
            return new byte[0];
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                z(bufferedInputStream, byteArrayOutputStream, 2048);
                return byteArrayOutputStream.toByteArray();
            } catch (IOException e) {
                wp.z(e);
                try {
                    bufferedInputStream.close();
                    byteArrayOutputStream.close();
                } catch (Exception unused) {
                }
                return new byte[0];
            }
        } finally {
            try {
                bufferedInputStream.close();
                byteArrayOutputStream.close();
            } catch (Exception unused2) {
            }
        }
    }

    private static long z(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = inputStream.read(bArr);
        long j = 0;
        while (i2 >= 0) {
            outputStream.write(bArr, 0, i2);
            j += (long) i2;
            i2 = inputStream.read(bArr);
        }
        return j;
    }
}
