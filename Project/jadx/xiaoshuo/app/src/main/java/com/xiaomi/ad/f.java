package com.xiaomi.ad;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f7260a = "IOUtil";

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            while (hexString.length() < 2) {
                hexString = "0" + hexString;
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            try {
                try {
                    int i = inputStream.read(bArr, 0, 8192);
                    if (i <= 0) {
                        return byteArrayOutputStream.toByteArray();
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                } catch (Exception e) {
                    e.printStackTrace();
                    a((Closeable) inputStream);
                    a(byteArrayOutputStream);
                    return null;
                }
            } finally {
                a((Closeable) inputStream);
                a(byteArrayOutputStream);
            }
            a((Closeable) inputStream);
            a(byteArrayOutputStream);
        }
    }
}
