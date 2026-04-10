package com.kwad.sdk.core.kwai;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    public static byte[] a(String str, byte[] bArr) {
        return a(str.getBytes(UTF_8), bArr, 2);
    }

    private static byte[] a(byte[] bArr, byte[] bArr2, int i2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(i2, secretKeySpec);
            return cipher.doFinal(bArr2);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
            return new byte[0];
        }
    }

    public static byte[] d(byte[] bArr, byte[] bArr2) {
        return a(bArr, bArr2, 1);
    }

    private static void e(InputStream inputStream, OutputStream outputStream) throws Throwable {
        GZIPOutputStream gZIPOutputStream;
        try {
            gZIPOutputStream = new GZIPOutputStream(outputStream);
        } catch (Throwable th) {
            th = th;
            gZIPOutputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i2 = inputStream.read(bArr, 0, 1024);
                if (i2 == -1) {
                    gZIPOutputStream.finish();
                    gZIPOutputStream.flush();
                    com.kwad.sdk.crash.utils.b.closeQuietly(gZIPOutputStream);
                    return;
                }
                gZIPOutputStream.write(bArr, 0, i2);
            }
        } catch (Throwable th2) {
            th = th2;
            com.kwad.sdk.crash.utils.b.closeQuietly(gZIPOutputStream);
            throw th;
        }
    }

    private static void f(InputStream inputStream, OutputStream outputStream) throws Throwable {
        GZIPInputStream gZIPInputStream;
        try {
            gZIPInputStream = new GZIPInputStream(inputStream);
        } catch (Throwable th) {
            th = th;
            gZIPInputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i2 = gZIPInputStream.read(bArr, 0, 1024);
                if (i2 == -1) {
                    com.kwad.sdk.crash.utils.b.closeQuietly(gZIPInputStream);
                    return;
                }
                outputStream.write(bArr, 0, i2);
            }
        } catch (Throwable th2) {
            th = th2;
            com.kwad.sdk.crash.utils.b.closeQuietly(gZIPInputStream);
            throw th;
        }
    }

    public static byte[] f(byte[] bArr) throws Throwable {
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    e(byteArrayInputStream, byteArrayOutputStream2);
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    byteArrayOutputStream2.flush();
                    com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream2);
                    com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayInputStream);
                    return byteArray;
                } catch (Throwable th) {
                    byteArrayOutputStream = byteArrayOutputStream2;
                    th = th;
                    com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream);
                    com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayInputStream = null;
        }
    }

    public static byte[] g(byte[] bArr) throws Throwable {
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    f(byteArrayInputStream, byteArrayOutputStream2);
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    byteArrayOutputStream2.flush();
                    com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream2);
                    com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayInputStream);
                    return byteArray;
                } catch (Throwable th) {
                    byteArrayOutputStream = byteArrayOutputStream2;
                    th = th;
                    com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream);
                    com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayInputStream = null;
        }
    }
}
