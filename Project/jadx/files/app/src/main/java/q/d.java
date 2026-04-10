package q;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: Md5Utils.java */
/* JADX INFO: loaded from: classes3.dex */
public class d {
    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] bArrDigest = messageDigest.digest();
            for (int i2 = 0; i2 < bArrDigest.length; i2++) {
                if ((bArrDigest[i2] & 255) < 16) {
                    stringBuffer.append("0" + Integer.toHexString(bArrDigest[i2] & 255));
                } else {
                    stringBuffer.append(Integer.toHexString(bArrDigest[i2] & 255));
                }
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException unused) {
            return "No";
        }
    }
}
