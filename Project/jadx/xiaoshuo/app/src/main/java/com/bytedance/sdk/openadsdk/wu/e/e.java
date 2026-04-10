package com.bytedance.sdk.openadsdk.wu.e;

import com.google.common.base.Ascii;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes10.dex */
public final class e {
    private static final byte[] e = {71, 73, 70, 56, 55, 97};
    private static final byte[] bf = {71, 73, 70, 56, 57, 97};
    private static final byte[] d = {-1, -40, -1};
    private static final byte[] tg = {-119, 80, 78, 71, Ascii.CR, 10, Ascii.SUB, 10};

    public static void bf(String str) throws Exception {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            int length = fileArrListFiles.length;
            for (int i = 0; i < length; i++) {
                if (fileArrListFiles[i].isDirectory()) {
                    bf(fileArrListFiles[i].getAbsolutePath());
                } else {
                    fileArrListFiles[i].delete();
                }
            }
            file.delete();
        }
    }

    public static byte[] e(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        try {
            return e(new FileInputStream(file));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:90:0x00bb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean e(java.io.InputStream r9, java.lang.String r10, java.lang.String r11, long r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 215
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.wu.e.e.e(java.io.InputStream, java.lang.String, java.lang.String, long):boolean");
    }

    public static byte[] e(InputStream inputStream) {
        if (inputStream == null) {
            return new byte[0];
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                e(bufferedInputStream, byteArrayOutputStream, 2048);
                return byteArrayOutputStream.toByteArray();
            } catch (IOException e2) {
                e2.printStackTrace();
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

    private static long e(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
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
