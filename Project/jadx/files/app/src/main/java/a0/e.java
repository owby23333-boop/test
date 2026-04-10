package a0;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: CryptoUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class e {
    public static final byte[] a = b.a("x04VOtkJ");

    /* JADX INFO: compiled from: CryptoUtils.java */
    public static class a {
        public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(bArr3));
            return cipher.doFinal(bArr);
        }
    }

    /* JADX INFO: compiled from: CryptoUtils.java */
    public static class c {
        public static byte[] a(byte[] bArr) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            } catch (Throwable th) {
                try {
                    gZIPOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    /* JADX INFO: compiled from: CryptoUtils.java */
    public static class b {
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
                return "No";
            }
        }

        public static byte[] a(String str) {
            if (str == null) {
                return null;
            }
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(str.getBytes());
                return messageDigest.digest();
            } catch (NoSuchAlgorithmException unused) {
                return null;
            }
        }
    }
}
