package fm.qingting.common.digest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes8.dex */
public class MD5 {
    private static ThreadLocal<MessageDigest> digestThreadLocal = new ThreadLocal<MessageDigest>() { // from class: fm.qingting.common.digest.MD5.1
        @Override // java.lang.ThreadLocal
        public MessageDigest initialValue() {
            try {
                return MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    };

    public static byte[] md5Bytes(String str) {
        return md5Bytes(str.getBytes(Charsets.UTF_8));
    }

    public static String md5String(String str, boolean upperCase) {
        return Digits.bytesToHex(md5Bytes(str), upperCase);
    }

    public static byte[] md5Bytes(byte[] src) {
        MessageDigest messageDigest = digestThreadLocal.get();
        messageDigest.reset();
        messageDigest.update(src);
        return messageDigest.digest();
    }

    public static String md5String(String str) {
        return md5String(str, false);
    }
}
