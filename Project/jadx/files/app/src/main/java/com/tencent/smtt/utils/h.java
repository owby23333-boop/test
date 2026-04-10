package com.tencent.smtt.utils;

import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

/* JADX INFO: loaded from: classes3.dex */
public class h {
    private static String b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static byte[] f19258c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f19260g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Cipher f19261d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Cipher f19262e;
    protected static final char[] a = "0123456789abcdef".toCharArray();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static h f19259f = null;

    private h() throws Exception {
        this.f19261d = null;
        this.f19262e = null;
        f19260g = String.valueOf(new Random().nextInt(89999999) + 10000000) + String.valueOf(new Random().nextInt(89999999) + 10000000) + String.valueOf(new Random().nextInt(89999999) + 10000000);
        String str = "00000000";
        for (int i2 = 0; i2 < 12; i2++) {
            str = str + String.valueOf(new Random().nextInt(89999999) + 10000000);
        }
        f19258c = (str + f19260g).getBytes();
        this.f19261d = Cipher.getInstance("RSA/ECB/NoPadding");
        this.f19261d.init(1, KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(android.util.Base64.decode((d() + e()).getBytes(), 0))));
        b = b(this.f19261d.doFinal(f19258c));
        SecretKey secretKeyGenerateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(f19260g.getBytes()));
        this.f19262e = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        this.f19262e.init(1, secretKeyGenerateSecret);
    }

    public static h a() {
        try {
            if (f19259f == null) {
                f19259f = new h();
            }
            return f19259f;
        } catch (Exception e2) {
            f19259f = null;
            e2.printStackTrace();
            return null;
        }
    }

    public static byte[] a(byte[] bArr, String str) throws Exception {
        SecretKey secretKeyGenerateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(str.getBytes()));
        Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        cipher.init(1, secretKeyGenerateSecret);
        return cipher.doFinal(bArr);
    }

    public static String b(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = bArr[i2] & 255;
            int i4 = i2 * 2;
            char[] cArr2 = a;
            cArr[i4] = cArr2[i3 >>> 4];
            cArr[i4 + 1] = cArr2[i3 & 15];
        }
        return new String(cArr);
    }

    public static byte[] b(byte[] bArr, String str) {
        try {
            SecretKey secretKeyGenerateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(str.getBytes()));
            Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            cipher.init(2, secretKeyGenerateSecret);
            return cipher.doFinal(bArr);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String c() {
        return f19260g;
    }

    private String d() {
        return "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDcEQ3TCNWPBqgIiY7WQ/IqTOTTV2w8aZ/GPm68FK0";
    }

    private String e() {
        return "fAJBemZKtYR3Li46VJ+Hwnor7ZpQnblGWPFaLv5JoPqvavgB0GInuhm+T+syPs1mw0uPLWaqwvZsCfoaIvUuxy5xHJgmWARrK4/9pHyDxRlZte0PCIoR1ko5B8lVVH1X1dQIDAQAB";
    }

    public byte[] a(byte[] bArr) throws Exception {
        return this.f19262e.doFinal(bArr);
    }

    public String b() {
        return b;
    }

    public byte[] c(byte[] bArr) {
        TbsLog.i("Post3DESEncryption", "DesDecrypt deskeys is " + f19260g);
        try {
            SecretKey secretKeyGenerateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(f19260g.getBytes()));
            Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            cipher.init(2, secretKeyGenerateSecret);
            return cipher.doFinal(bArr);
        } catch (Exception e2) {
            try {
                TbsLog.i("Post3DESEncryption", "DesDecrypt exception,  content is " + d(bArr));
            } catch (Throwable unused) {
            }
            TbsLog.i(e2);
            return null;
        }
    }

    public String d(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = bArr[i2] & 255;
            sb.append("0x");
            String hexString = Integer.toHexString(i3);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
            if (i2 != bArr.length - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
}
