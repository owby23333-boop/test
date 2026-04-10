package com.yuewen;

import android.util.Base64;
import com.duokan.kernel.DkUtils;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes5.dex */
public abstract class k20 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f13336a = DkUtils.getDkChapterEncryptKey();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static byte[] f13337b;
    public static byte[] c;

    public static String a(byte b2) {
        int i = (b2 & 127) + (b2 < 0 ? 128 : 0);
        StringBuilder sb = new StringBuilder();
        sb.append(i < 16 ? "0" : "");
        sb.append(Integer.toHexString(i).toLowerCase());
        return sb.toString();
    }

    public static String b(String str) {
        try {
            if (f13337b == null) {
                f13337b = c();
            }
            if (c == null) {
                c = d();
            }
            IvParameterSpec ivParameterSpec = new IvParameterSpec(f13337b);
            SecretKeySpec secretKeySpec = new SecretKeySpec(c, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(2, secretKeySpec, ivParameterSpec);
            return new String(cipher.doFinal(Base64.decode(str.getBytes(), 8)), StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static byte[] c() {
        try {
            return MessageDigest.getInstance("MD5").digest(Base64.decode(f13336a.getBytes(StandardCharsets.UTF_8), 8));
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static byte[] d() {
        return Base64.decode(f13336a.getBytes(StandardCharsets.UTF_8), 8);
    }

    public static String e(String str, long j) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest((str + "_" + j).getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArrDigest) {
                sb.append(a(b2));
            }
            return sb.toString().toUpperCase();
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }
}
