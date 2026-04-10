package r;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: compiled from: Utils.java */
/* JADX INFO: loaded from: classes3.dex */
public class e {
    public static byte[] a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static String a() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }
}
