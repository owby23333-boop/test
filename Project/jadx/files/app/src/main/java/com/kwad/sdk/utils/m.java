package com.kwad.sdk.utils;

import androidx.annotation.RequiresApi;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class m {
    public static void a(File[] fileArr, String str) throws Throwable {
        a(fileArr, str, -1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7, types: [java.util.zip.ZipOutputStream] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    private static void a(File[] fileArr, String str, int i2) throws Throwable {
        ?? bufferedInputStream;
        ?? r9 = 0;
         = 0;
        ?? r92 = 0;
        try {
            try {
                str = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream((String) str)));
                try {
                    byte[] bArr = new byte[4096];
                    ?? r3 = 0;
                    int i3 = 0;
                    while (i3 < fileArr.length) {
                        try {
                            bufferedInputStream = new BufferedInputStream(new FileInputStream(fileArr[i3]), 4096);
                        } catch (Exception e2) {
                            e = e2;
                            r92 = r3;
                        } catch (Throwable th) {
                            th = th;
                            bufferedInputStream = r3;
                        }
                        try {
                            String absolutePath = fileArr[i3].getAbsolutePath();
                            str.putNextEntry(new ZipEntry(absolutePath.substring(absolutePath.lastIndexOf("/") + 1)));
                            while (true) {
                                int i4 = bufferedInputStream.read(bArr, 0, 4096);
                                if (i4 == -1) {
                                    break;
                                } else {
                                    str.write(bArr, 0, i4);
                                }
                            }
                            bufferedInputStream.close();
                            r3 = bufferedInputStream;
                            i3++;
                        } catch (Exception e3) {
                            e = e3;
                            r92 = bufferedInputStream;
                            com.kwad.sdk.core.d.b.printStackTrace(e);
                            com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) r92);
                            str = str;
                            r9 = r92;
                            com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) str);
                        } catch (Throwable th2) {
                            th = th2;
                            com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) bufferedInputStream);
                            com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) str);
                            throw th;
                        }
                    }
                    com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) r3);
                    str = str;
                    r9 = i3;
                } catch (Exception e4) {
                    e = e4;
                }
            } catch (Exception e5) {
                e = e5;
                str = 0;
            } catch (Throwable th3) {
                th = th3;
                str = 0;
                bufferedInputStream = 0;
            }
            com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) str);
        } catch (Throwable th4) {
            th = th4;
            bufferedInputStream = r9;
        }
    }

    @RequiresApi(api = 19)
    public static byte[] k(byte[] bArr) {
        byte[] byteArray = null;
        if (bArr != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
                try {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    try {
                        gZIPOutputStream.write(bArr);
                        gZIPOutputStream.flush();
                        gZIPOutputStream.close();
                        byteArrayOutputStream.flush();
                        byteArrayOutputStream.close();
                        byteArray = byteArrayOutputStream.toByteArray();
                        gZIPOutputStream.close();
                        byteArrayOutputStream.close();
                    } finally {
                    }
                } finally {
                }
            } catch (IOException e2) {
                com.kwad.sdk.core.d.b.printStackTrace(e2);
            }
        }
        return byteArray;
    }
}
