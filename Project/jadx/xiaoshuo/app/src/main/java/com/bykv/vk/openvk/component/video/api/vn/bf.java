package com.bykv.vk.openvk.component.video.api.vn;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes.dex */
public class bf {
    private static final MessageDigest e = e();
    private static final char[] bf = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private bf() {
    }

    private static MessageDigest e() {
        try {
            return MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static String e(String str) {
        byte[] bArrDigest;
        MessageDigest messageDigest = e;
        if (messageDigest == null || TextUtils.isEmpty(str)) {
            return "";
        }
        byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
        synchronized (bf.class) {
            bArrDigest = messageDigest.digest(bytes);
        }
        return e(bArrDigest);
    }

    public static String e(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[bArr.length << 1];
        int i = 0;
        for (byte b2 : bArr) {
            int i2 = i + 1;
            char[] cArr2 = bf;
            cArr[i] = cArr2[(b2 & 240) >> 4];
            i = i2 + 1;
            cArr[i2] = cArr2[b2 & Ascii.SI];
        }
        return new String(cArr);
    }
}
