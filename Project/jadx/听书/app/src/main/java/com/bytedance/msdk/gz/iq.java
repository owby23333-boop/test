package com.bytedance.msdk.gz;

import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes2.dex */
public class iq {
    private static final MessageDigest g = z();
    public static final Charset z = Charset.forName("UTF-8");
    private static final char[] dl = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private iq() {
    }

    private static MessageDigest z() {
        try {
            return MessageDigest.getInstance(TKDownloadReason.KSAD_TK_MD5);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static String z(String str) {
        byte[] bArrDigest;
        MessageDigest messageDigest = g;
        if (str == null) {
            return "";
        }
        byte[] bytes = str.getBytes(z);
        synchronized (iq.class) {
            bArrDigest = messageDigest.digest(bytes);
        }
        return z(bArrDigest);
    }

    public static String z(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[bArr.length << 1];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = dl;
            cArr[i] = cArr2[(b & 240) >> 4];
            i = i2 + 1;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }
}
