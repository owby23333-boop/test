package com.yuewen;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes12.dex */
public class yu3 {
    public static void a(Context context, OutputStream outputStream, int i) throws Throwable {
        InputStream inputStreamOpenRawResource = null;
        try {
            inputStreamOpenRawResource = context.getResources().openRawResource(i);
            byte[] bArr = new byte[1048576];
            while (true) {
                int i2 = inputStreamOpenRawResource.read(bArr);
                if (i2 < 0) {
                    try {
                        inputStreamOpenRawResource.close();
                        return;
                    } catch (Throwable unused) {
                        return;
                    }
                }
                outputStream.write(bArr, 0, i2);
            }
        } catch (Throwable th) {
            if (inputStreamOpenRawResource != null) {
                try {
                    inputStreamOpenRawResource.close();
                } catch (Throwable unused2) {
                }
            }
            throw th;
        }
    }

    public static void b(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Throwable unused) {
        }
    }

    public static void c(InputStream inputStream, OutputStream outputStream) throws IOException {
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

    public static byte[] d(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        try {
            c(inputStream, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } finally {
            b(byteArrayOutputStream);
        }
    }
}
