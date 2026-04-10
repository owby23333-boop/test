package com.kingsoft.iciba.sdk2.a;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes7.dex */
public class StreamUtils {
    public static void safeClose(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Throwable unused) {
        }
    }

    public static void saveAs(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int i = inputStream.read(bArr, 0, 1024);
            if (i <= 0) {
                outputStream.flush();
                return;
            }
            outputStream.write(bArr, 0, i);
        }
    }

    public static byte[] saveAsBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        try {
            saveAs(inputStream, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } finally {
            safeClose(byteArrayOutputStream);
        }
    }
}
