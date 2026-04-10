package com.amgcyo.cuttadon.utils.comic;

import android.text.TextUtils;
import com.amgcyo.cuttadon.api.entity.comic.Base64Bean;
import com.amgcyo.cuttadon.utils.otherutils.r;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import me.jessyan.art.http.imageloader.glide.GlideFileUtil;

/* JADX INFO: compiled from: ComicsUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private static String a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return new String(a(new SecretKeySpec(bArr2, "AES"), new IvParameterSpec(bArr3), bArr));
    }

    public static <T> List<T> b(Base64Bean base64Bean, Class cls) {
        if (base64Bean == null) {
            return null;
        }
        String strA = a(base64Bean);
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        return r.b(strA, cls);
    }

    private static byte[] c(String str) {
        byte[] bArr;
        int length = str.length();
        if (length % 2 == 1) {
            length++;
            bArr = new byte[length / 2];
            str = "0" + str;
        } else {
            bArr = new byte[length / 2];
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = i2 + 2;
            bArr[i3] = b(str.substring(i2, i4));
            i3++;
            i2 = i4;
        }
        return bArr;
    }

    public static String a(Base64Bean base64Bean) {
        int ver = base64Bean.getVer();
        if (ver == 0 || ver != 1) {
            return null;
        }
        byte[] bArrB = me.jessyan.art.b.a.b(base64Bean.getContent());
        if (bArrB != null) {
            String strA = a(new String(GlideFileUtil.subBytes(bArrB, 0, 16)));
            byte[] bArrSubBytes = GlideFileUtil.subBytes(bArrB, 16, bArrB.length - 32);
            String str = new String(GlideFileUtil.subBytes(bArrB, bArrB.length - 16, 16));
            String strA2 = com.open.hule.library.c.b.a(str);
            byte[] bytes = str.getBytes();
            byte[] bytes2 = strA2.getBytes();
            byte[] bArr = new byte[16];
            for (int i2 = 0; i2 < 16; i2++) {
                bArr[i2] = (byte) ((bytes2[i2] ^ bytes[i2]) ^ (-1));
            }
            return a(bArrSubBytes, c(strA), bArr);
        }
        System.out.println("  byte[] is null please check...");
        return null;
    }

    private static byte b(String str) {
        return (byte) Integer.parseInt(str, 16);
    }

    public static <T> T a(Base64Bean base64Bean, Class<T> cls) {
        if (base64Bean == null) {
            return null;
        }
        try {
            String strA = a(base64Bean);
            if (TextUtils.isEmpty(strA)) {
                return null;
            }
            return (T) r.a(strA, (Class) cls);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes(StandardCharsets.US_ASCII));
            return a(messageDigest.digest());
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    private static byte[] a(SecretKey secretKey, IvParameterSpec ivParameterSpec, byte[] bArr) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKey, ivParameterSpec);
            return cipher.doFinal(bArr);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
