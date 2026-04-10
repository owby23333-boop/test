package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import com.umeng.analytics.pro.cb;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes.dex */
public class y {
    private static final MessageDigest a = a();
    public static final Charset b = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final char[] f1805c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private y() {
    }

    public static String a(String str) {
        byte[] bArrDigest;
        MessageDigest messageDigest = a;
        if (str == null) {
            return "";
        }
        byte[] bytes = str.getBytes(b);
        synchronized (y.class) {
            bArrDigest = messageDigest.digest(bytes);
        }
        return a(bArrDigest);
    }

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[bArr.length << 1];
        int i2 = 0;
        for (byte b2 : bArr) {
            int i3 = i2 + 1;
            char[] cArr2 = f1805c;
            cArr[i2] = cArr2[(b2 & 240) >> 4];
            i2 = i3 + 1;
            cArr[i3] = cArr2[b2 & cb.f19604m];
        }
        return new String(cArr);
    }

    private static MessageDigest a() {
        try {
            return MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }
}
