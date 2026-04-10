package e0;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: Utils.java */
/* JADX INFO: loaded from: classes3.dex */
public class g {
    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            for (byte b : messageDigest.digest()) {
                int i2 = b & 255;
                if (i2 < 16) {
                    stringBuffer.append("0" + Integer.toHexString(i2));
                } else {
                    stringBuffer.append(Integer.toHexString(i2));
                }
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }
}
