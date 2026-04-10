package com.yuewen.openapi.utils;

import android.util.Log;
import com.yuewen.p;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes8.dex */
public class GzipUtil {
    public static byte[] compressData(String str) throws Throwable {
        Closeable closeable;
        GZIPOutputStream gZIPOutputStream;
        Closeable closeable2 = null;
        try {
            byte[] bytes = str.getBytes("UTF-8");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bytes.length);
            try {
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            } catch (Throwable th) {
                th = th;
            }
            try {
                gZIPOutputStream.write(bytes);
                gZIPOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                p.a(null, null);
                return byteArray;
            } catch (Throwable th2) {
                th = th2;
                closeable2 = gZIPOutputStream;
                closeable = closeable2;
                closeable2 = byteArrayOutputStream;
                p.a(closeable2, closeable);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            closeable = null;
        }
    }

    public static String uncompressToString(byte[] bArr, String str) {
        if (bArr != null && bArr.length != 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr));
                byte[] bArr2 = new byte[256];
                while (true) {
                    int i = gZIPInputStream.read(bArr2);
                    if (i < 0) {
                        return byteArrayOutputStream.toString(str);
                    }
                    byteArrayOutputStream.write(bArr2, 0, i);
                }
            } catch (IOException e) {
                Log.e("gzip compress error.", e.getMessage());
            }
        }
        return null;
    }
}
