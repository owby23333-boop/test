package com.ss.android.downloadlib.mb.mb;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static byte[] mb(CharSequence charSequence, String str) throws Exception {
        return mb(charSequence.toString().getBytes(), str);
    }

    public static byte[] mb(byte[] bArr, String str) throws Exception {
        return mb(new ByteArrayInputStream(bArr), str);
    }

    public static byte[] mb(InputStream inputStream, String str) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        byte[] bArr = new byte[4096];
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 <= 0) {
                return messageDigest.digest();
            }
            messageDigest.update(bArr, 0, i2);
        }
    }
}
