package com.yuewen;

import android.text.TextUtils;
import android.util.Base64;
import com.yuewen.gm;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes5.dex */
public class f40 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f11047b = "AES/CBC/PKCS5Padding";
    public static final String[] c = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", com.xiaomi.ad.y.j, gm.a.f11596b, "d", "e", gm.a.f11595a};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public es f11048a;

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : bArr) {
            stringBuffer.append(b(b2));
        }
        return stringBuffer.toString();
    }

    public static String b(byte b2) {
        int i = b2;
        if (b2 < 0) {
            i = b2 + 256;
        }
        StringBuilder sb = new StringBuilder();
        String[] strArr = c;
        sb.append(strArr[i / 16]);
        sb.append(strArr[i % 16]);
        return sb.toString();
    }

    public static final String c(String str, String str2) {
        byte[] bArrE;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (bArrE = e(str2)) != null && bArrE.length == 16) {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArrE, "AES");
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(2, secretKeySpec, new IvParameterSpec("0102030405060708".getBytes()));
                byte[] bArrE2 = e(str);
                if (bArrE2 == null) {
                    return null;
                }
                return new String(cipher.doFinal(bArrE2));
            } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException unused) {
            }
        }
        return null;
    }

    public static final String d(String str) {
        return new String(Base64.decode(str, 0));
    }

    public static final byte[] e(String str) {
        return Base64.decode(str, 0);
    }

    public static final String f(String str, String str2) {
        byte[] bArrE;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (bArrE = e(str2)) != null && bArrE.length == 16) {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArrE, "AES");
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(1, secretKeySpec, new IvParameterSpec("0102030405060708".getBytes()));
                return h(cipher.doFinal(str.getBytes()));
            } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException unused) {
            }
        }
        return null;
    }

    public static final String g(String str) {
        return Base64.encodeToString(str.getBytes(), 2);
    }

    public static final String h(byte[] bArr) {
        return Base64.encodeToString(bArr, 2);
    }

    public static final byte[] i(String str) {
        return Base64.encode(str.getBytes(), 2);
    }

    public static final String j(File file) {
        FileInputStream fileInputStream;
        byte[] bArr = new byte[1024];
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    while (true) {
                        int i = fileInputStream.read(bArr);
                        if (i > 0) {
                            messageDigest.update(bArr, 0, i);
                        } else {
                            try {
                                break;
                            } catch (IOException e) {
                            }
                        }
                    }
                    return a(messageDigest.digest());
                } catch (IOException e2) {
                    e2.printStackTrace();
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    return null;
                } catch (NoSuchAlgorithmException e4) {
                    e4.printStackTrace();
                    try {
                        fileInputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    return null;
                }
            } finally {
                try {
                    fileInputStream.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
        } catch (FileNotFoundException e7) {
            e7.printStackTrace();
            return null;
        }
    }

    public static final String k(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return a(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static final String l(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA");
            messageDigest.update(str.getBytes());
            return a(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static final byte[] m(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA");
            messageDigest.update(str.getBytes());
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
