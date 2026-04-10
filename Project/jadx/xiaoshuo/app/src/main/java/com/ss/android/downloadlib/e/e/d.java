package com.ss.android.downloadlib.e.e;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes4.dex */
public class d {
    public static byte[] e(CharSequence charSequence, String str) throws Exception {
        return e(charSequence.toString().getBytes(), str);
    }

    public static byte[] e(byte[] bArr, String str) throws Exception {
        return e(new ByteArrayInputStream(bArr), str);
    }

    public static byte[] e(InputStream inputStream, String str) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        byte[] bArr = new byte[4096];
        while (true) {
            int i = inputStream.read(bArr);
            if (i <= 0) {
                return messageDigest.digest();
            }
            messageDigest.update(bArr, 0, i);
        }
    }
}
