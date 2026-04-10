package com.dangdang.zframework.utils;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes10.dex */
public class StreamUtil {
    public static void closeStream(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static byte[] getBytesFromStream(InputStream inputStream) {
        return getBytesFromStream(inputStream, 2048);
    }

    public static byte[] getBytesFromStream(InputStream inputStream, int i) {
        byte[] byteArray = null;
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[i];
        while (true) {
            try {
                try {
                    int i2 = inputStream.read(bArr);
                    if (i2 <= -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return byteArray;
            } finally {
                closeStream(inputStream);
                closeStream(byteArrayOutputStream);
            }
        }
        byteArray = byteArrayOutputStream.toByteArray();
        return byteArray;
    }
}
